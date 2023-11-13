package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDto {
    private Long id;

    private Long conversationId;

    private String text;

    //1==질문, 2==답변
    private String type;

    private Long contentId;

    private String content;

    private LocalDateTime createdAt;

}


