package com.aifred.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aifred.dto.Hello;

@RestController
//@RequestMapping("/test")
public class TestControler {

	@GetMapping("/helloWorld")
	public ResponseEntity<Hello> helloWorld(Hello requestBody)
	{

		requestBody.setResponse("Hello!     " + requestBody.getInput() );

		//return "Greetings from Spring Boot!";
		return new ResponseEntity<>(requestBody, HttpStatus.OK);

		// return new ResponseEntity<>(hello, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
