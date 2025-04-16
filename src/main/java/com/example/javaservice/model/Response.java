package com.example.javaservice.model;

public class Response {
    private String message;
    private long timestamp;

    // Default constructor required for JSON serialization
    public Response() {
        this.timestamp = System.currentTimeMillis();
    }

    public Response(String message) {
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
