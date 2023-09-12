package com.aifred.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hello {
	
	@Id
	private String input;
	
	private String response;

	
	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}
	
	
}
