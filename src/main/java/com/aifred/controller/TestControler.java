package com.aifred.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Iterators;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.demo.ask.CommunicatorGrpc;
import io.grpc.demo.ask.Content;
import io.grpc.demo.ask.Conversation;
import io.grpc.demo.ask.Message;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aifred.dto.Hello;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


@RestController
@RequestMapping("/api")
//@RequestMapping("/test")
public class TestControler {

	List<String> list = new ArrayList<String>();

	@GetMapping("/askQuestion")
	public ResponseEntity<Hello> helloWorld(Hello requestBody, HttpServletRequest request) {



		//requestBody.setResponse("Hello!\n Your ip address is : " + request.getRemoteAddr());

		String msg = "Hello!\n Your ip address is : " + request.getRemoteAddr();



		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// return "Greetings from Spring Boot!";
		return new ResponseEntity<>(requestBody, HttpStatus.OK);

		// return new ResponseEntity<>(hello, HttpStatus.OK);
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}




	@GetMapping("/stream-data")
	public Flux<Object> streamData() {
		return Flux
				.create(sink -> {
					// 여기에 스트림 데이터 생성 로직을 구현합니다.
					for (int i = 0; i < 10; i++) {
						// 데이터를 스트림에 emit 합니다.
						sink.next(i);

						try {
							Thread.sleep(1000); // 1초마다 데이터 생성
						} catch (InterruptedException e) {
							throw new RuntimeException(e);
						}
					}
					sink.complete(); // 스트림 종료
				})
				.delayElements(Duration.ofSeconds(1)); // 1초 간격으로 데이터를 전송하도록 설정
	}


	@GetMapping("/stream")
	Flux<Map<String, String>> stream() {

		String msg = "반갑습니다 무엇을 도와 드릴까요?";

		Stream<String> stream = Arrays.stream(msg.split("")); // 문자열을 문자 단위로 분할하여 스트림 생성


		//Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
		return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(1)))
				.map(tuple -> Collections.singletonMap("value", tuple.getT1() /* 튜플의 첫 번째 요소 = Stream<Integer> 요소 */));


	}

	@GetMapping("/stream2")
	Flux<String> stream2() {

		return Flux.generate(
				// 초기 상태
				() -> 0,

				// 상태를 업데이트하고 데이터를 생성하는 BiFunction
				(state, sink) -> {
					sink.next("Data " + state);
					if (state == 10) {
						sink.complete(); // 스트림 완료
					}

					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return state + 1;
				}
		);
	}

	@GetMapping(value = "/stream3", produces = "text/event-stream")
	public Flux<Integer> stream3() {
		Flux<Integer> flux = Flux.generate(
				() -> 1, // 초기 상태
				(state, sink) -> {
					if (state <= 5) {
						sink.next(state); // 데이터 생성
					} else {
						sink.complete(); // 스트림 완료
					}
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return state + 1; // 상태 업데이트
				}
		);
		return flux;
	}



	@GetMapping(value = "/streamPush", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
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

//		Iterator<Conversation> iterator = blockingStub.askStreamReply(conversation);
//
//			return Flux.create(sink -> {
//				Iterator<Conversation> conversationIterator = blockingStub.askStreamReply(conversation);
//
//				Schedulers.boundedElastic().schedule(() -> {
//					while (conversationIterator.hasNext()) {
//						Conversation conversation2 = conversationIterator.next();
//						sink.next(conversation2.getMessage().getText());
//						System.out.println(conversation2.getMessage().getText());
//					}
//					sink.complete();
//				});
//			});

				//	.map(tuple -> Collections.singletonMap("value", tuple));

		return  null;
		}


}

