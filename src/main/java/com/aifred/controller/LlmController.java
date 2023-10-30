package com.aifred.controller;

import com.aifred.DemoClient;
import com.aifred.dto.QuestionRequest;
import com.aifred.service.LlmService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.demo.ask.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.Iterator;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/llm")
public class LlmController {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	LlmService llmService;

	@PostMapping(value = "/askContents")
	public ResponseEntity<String> askContents(@RequestBody  QuestionRequest questionRequest) {
		Message message = Message.newBuilder().setText(questionRequest.getQuestion()).build();

		//TODO:포트정보 프로퍼티에
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
		CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);

		Content content = blockingStub.searchContent(message);

		return new ResponseEntity<String>(content.getContent(), HttpStatus.OK);
	}


	@PostMapping(value = "/ask", produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<String> streamDataPush(@RequestBody  QuestionRequest questionRequest) {
		Content content = Content.newBuilder().setContent(questionRequest.getContent()).build();
		Message message = Message.newBuilder().setText(questionRequest.getQuestion()).build();

		Conversation conversation = Conversation
				.newBuilder()
				.addContent(content)
				.setMessage(message)
				.build();

		//TODO:포트정보 프로퍼티에
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051).usePlaintext().build();

		CommunicatorGrpc.CommunicatorStub stub = CommunicatorGrpc.newStub(channel);
		CommunicatorGrpc.CommunicatorBlockingStub blockingStub = CommunicatorGrpc.newBlockingStub(channel);

		return Flux.create(sink -> {
			Iterator<Message> iter = blockingStub.askStreamReply(conversation);

			Schedulers.boundedElastic().schedule(() -> {
				while (iter.hasNext()) {
					Message returnMessage = iter.next();
					sink.next(returnMessage.getText());
					while (iter.hasNext()) {
						Message response = iter.next();
						sink.next(response.getText());
					}
					sink.complete();
				}
			});
		});
	}
}