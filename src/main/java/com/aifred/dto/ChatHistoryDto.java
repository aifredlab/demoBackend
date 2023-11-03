package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatHistoryDto {
    private Long conversationId;

    private Long contentId;
    private String content;

    private String question;
    private String answer;
}
