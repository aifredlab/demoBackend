package com.aifred.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "message_auto_generator",
        sequenceName = "message_auto",
        initialValue = 1000000000, allocationSize = 10)
public class Message extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_auto_generator")
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false, length = 1)
    private String type;

    @Column(nullable = false)
    private String createdBy;

}
