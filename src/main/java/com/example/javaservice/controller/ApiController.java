package com.example.javaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.javaservice.model.Message;
import com.example.javaservice.model.Response;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final Map<String, Message> messages = new HashMap<>();

    @GetMapping("/health")
    public ResponseEntity<Response> healthCheck() {
        Response response = new Response("Service is up and running");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable String id) {
        if (messages.containsKey(id)) {
            return ResponseEntity.ok(messages.get(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/book")
    public ResponseEntity<Response> createMessage(@RequestBody Message message) {
        String id = UUID.randomUUID().toString();
        message.setId(id);
        messages.put(id, message);
        
        Response response = new Response("Booking created with ID: " + id);
        return ResponseEntity.ok(response);
    }
}
