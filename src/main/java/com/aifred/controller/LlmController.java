package com.aifred.controller;

import com.aifred.dto.QuestionReply;
import com.aifred.dto.QuestionRequest;
import com.aifred.service.LlmService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.demo.ask.CommunicatorGrpc;
import io.grpc.demo.ask.Content;
import io.grpc.demo.ask.Conversation;
import io.grpc.demo.ask.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Iterator;


@RestController
@RequestMapping("/api")
public class LlmController {
	@Autowired
	LlmService llmService;
	
	@PostMapping("/ask")
	public ResponseEntity<QuestionReply> ask(@RequestBody QuestionRequest questionRequest) throws Exception {
		//TODO: Question 빈값 검증
		QuestionReply questionReply =  llmService.ask(questionRequest.getQuestion());
		return new ResponseEntity<QuestionReply>(questionReply, HttpStatus.OK);
	}

	//application/x-ndjson
	//@GetMapping(value = "/askPush", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@GetMapping(value = "/askPush", produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<String> streamDataPush() {
		Content content = Content.newBuilder().setContent("test").build();
		Message message = Message.newBuilder().setText("messageTest").build();

		Conversation conversation = Conversation
				.newBuilder()
				//.setContent(0, content)
				.setMessage(message)
				.build();

		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
		CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);

		Iterator<Conversation> iterator = blockingStub.askStreamReply(conversation);

		return Flux.create(sink -> {
			Iterator<Conversation> conversationIterator = blockingStub.askStreamReply(conversation);

			Schedulers.boundedElastic().schedule(() -> {
				while (conversationIterator.hasNext()) {
					Conversation conversation2 = conversationIterator.next();
					sink.next(conversation2.getMessage().getText());
					System.out.println(conversation2.getMessage().getText());
				}
				sink.complete();
			});
		});
	}



}