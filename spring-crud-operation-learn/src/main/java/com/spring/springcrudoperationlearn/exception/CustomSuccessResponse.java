package com.spring.springcrudoperationlearn.exception;
import java.time.LocalDateTime;

public class CustomSuccessResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;
    private Object data;

    public CustomSuccessResponse(int status, String message, LocalDateTime timestamp, Object data) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.data = data;
    }

    // Add getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
