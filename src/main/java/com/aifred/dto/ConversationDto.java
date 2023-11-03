package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConversationDto {
    private Long id;

    private String title;

    private LocalDateTime createdAt;
}
