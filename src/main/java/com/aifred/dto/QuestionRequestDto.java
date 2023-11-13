package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class QuestionRequestDto {
    Long conversationId;
    String question;
    String response;
    String content;
    String type;

    Long contentId;

    private LocalDateTime createdAt;
}
