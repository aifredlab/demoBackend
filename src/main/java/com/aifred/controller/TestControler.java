package com.aifred.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aifred.dto.Hello;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;


@RestController
@CrossOrigin(origins = "http://localhost:3000") //TODO:추후제거
//@RequestMapping("/test")
public class TestControler {

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




	@GetMapping(value = "/stream-data", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> streamData() {
		return Flux.create(sink -> {
			// 여기에 스트림 데이터 생성 로직을 구현합니다.
			for (int i = 0; i < 10; i++) {
				// 데이터를 스트림에 emit 합니다.
				sink.next(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
			sink.complete(); // 스트림 종료
		});
	}


	@GetMapping("/stream")
	Flux<Map<String, String>> stream() {

		String msg = "반갑습니다 무엇을 도와 드릴까요?";

		Stream<String> stream = Arrays.stream(msg.split("")); // 문자열을 문자 단위로 분할하여 스트림 생성


		//Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
		return Flux.fromStream(stream).zipWith(Flux.interval(Duration.ofSeconds(1)))
				.map(tuple -> Collections.singletonMap("value", tuple.getT1() /* 튜플의 첫 번째 요소 = Stream<Integer> 요소 */));


	}


	@GetMapping("/streamPush")
	public Flux<String> streamDataPush() {
		String msg = "반갑습니다 무엇을 도와 드릴까요?";
		String[] characters = msg.split("");

		// 문자열 배열을 Flux로 변환하여 push 방식으로 스트림 생성
		return Flux.fromArray(characters)
				.delayElements(Duration.ofSeconds(1)); // 1초 간격으로 요소를 전송
	}









}

