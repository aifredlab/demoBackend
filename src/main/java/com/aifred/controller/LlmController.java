package com.aifred.controller;

import com.aifred.dto.QuestionReply;
import com.aifred.dto.QuestionRequest;
import com.aifred.service.LlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class LlmController {
	
	@Autowired
	LlmService llmService;
	
	@PostMapping("/ask")
	public ResponseEntity<QuestionReply> ask(@RequestParam QuestionRequest questionRequest) throws Exception {
		QuestionReply questionReply =  llmService.ask(questionRequest.getQuestion());
		return new ResponseEntity<QuestionReply>(questionReply, HttpStatus.OK);
	}

	@GetMapping("/ask")
	public ResponseEntity<QuestionReply> ask2(@RequestParam QuestionRequest questionRequest) throws Exception {
		QuestionReply questionReply =  llmService.ask(questionRequest.getQuestion());
		return new ResponseEntity<QuestionReply>(questionReply, HttpStatus.OK);
	}


}