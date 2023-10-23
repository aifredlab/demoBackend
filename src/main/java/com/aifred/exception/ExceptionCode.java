package com.aifred.exception;

import lombok.Getter;

public enum ExceptionCode {

    USER_NOT_FOUND(100, "User not found"),
    USER_EMAIL_EXISTS(101, "User email already exists"),
    TOKEN_NOT_FOUND(110, "Token not found");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
