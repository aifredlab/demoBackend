package com.aifred.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ChatHistory {

    @Id
    private String id;

    @Column(nullable = false)
    private String question;

    private String refContents;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String memberId;

}
