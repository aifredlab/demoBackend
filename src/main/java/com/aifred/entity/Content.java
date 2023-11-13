package com.aifred.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@SequenceGenerator(name = "content_auto_generator",
        sequenceName = "content_auto",
        initialValue = 1000000000, allocationSize = 10)
public class Content extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "content_auto_generator")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long createdBy;

}
