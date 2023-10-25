package com.aifred.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private String email;
    private String company;
    private String password;
}
