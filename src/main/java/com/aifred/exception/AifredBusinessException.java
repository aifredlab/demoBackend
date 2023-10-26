package com.aifred.exception;

import lombok.Getter;

public class AifredBusinessException extends Exception{
    @Getter
    private ExceptionCode exceptionCode;
    private static final String MESSAGE = "사용자를 찾을 수 없습니다.";

    public AifredBusinessException(String message) {
        super(message);
    }

    public AifredBusinessException() {
        super(MESSAGE);
    }

    public AifredBusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode.getMessage());
        this.exceptionCode = exceptionCode;
    }
}
