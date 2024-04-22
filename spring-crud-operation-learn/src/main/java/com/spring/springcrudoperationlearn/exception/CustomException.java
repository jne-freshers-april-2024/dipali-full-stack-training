package com.spring.springcrudoperationlearn.exception;

import java.time.LocalDateTime;

public class CustomException extends RuntimeException{

    private String message;
    private LocalDateTime timestamp;

    public CustomException(String message) {
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
