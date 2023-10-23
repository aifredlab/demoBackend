package com.aifred.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatHistoryDto {
    private String id;
    private String question;
    private String refContents;
    private String createdAt;
    private String memberId;
}
