package com.aifred.controller;

import com.aifred.dto.Hello;
import com.aifred.dto.QuestionReply;
import com.aifred.entity.InsCompany;
import com.aifred.entity.Insurance;
import com.aifred.service.InsuranceService;
import com.aifred.service.LlmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LlmController {
	
	@Autowired
	LlmService llmService;
	
	@GetMapping("/ask")
	public ResponseEntity<QuestionReply> ask(String question) throws Exception {
		QuestionReply questionReply =  llmService.ask(question);
		return new ResponseEntity<QuestionReply>(questionReply, HttpStatus.OK);
	}


}