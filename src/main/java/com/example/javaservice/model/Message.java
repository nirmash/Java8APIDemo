package com.example.javaservice.model;

public class Message {
    private String id;
    private String content;
    private String author;
    private long timestamp;

    // Default constructor required for JSON deserialization
    public Message() {
        this.timestamp = System.currentTimeMillis();
    }

    public Message(String content, String author) {
        this.content = content;
        this.author = author;
        this.timestamp = System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
