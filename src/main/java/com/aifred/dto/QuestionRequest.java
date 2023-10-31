package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionRequest {

    String question;

    String content;

    List<String> questionHistory;
}
