package com.aifred.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "conversation_auto_generator",
        sequenceName = "conversation_auto",
        initialValue = 1000000000, allocationSize = 10)
public class Conversation extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conversation_auto_generator")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Long createdBy;

}

