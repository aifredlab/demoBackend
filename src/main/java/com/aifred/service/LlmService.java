package com.aifred.service;

import com.aifred.dto.QuestionReply;

public interface LlmService {

    public QuestionReply ask(String quesiton) throws Exception;

}
