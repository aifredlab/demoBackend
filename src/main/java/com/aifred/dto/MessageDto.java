package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    private Long id;

    private Long conversationId;

    private String text;

    //1==질문, 2==답변
    private String type;

    private String content;
}


