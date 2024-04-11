package com.spring.restfulwebservices.exception;

import java.time.LocalDate;

public class ErrorDetails {

    private LocalDate timpstamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDate timpstamp, String message, String details) {
        this.timpstamp = timpstamp;
        this.message = message;
        this.details = details;
    }

    public LocalDate getTimpstamp() {
        return timpstamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
