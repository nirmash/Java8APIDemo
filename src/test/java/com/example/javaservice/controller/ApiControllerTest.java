package com.example.javaservice.controller;

import com.example.javaservice.model.Message;
import com.example.javaservice.model.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void healthCheckShouldReturnSuccessMessage() {
        ResponseEntity<Response> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/health", Response.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getMessage()).contains("up and running");
    }

    @Test
    public void createMessageShouldReturnMessageId() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        
        Message message = new Message("Test content", "Test author");
        HttpEntity<Message> request = new HttpEntity<>(message, headers);
        
        ResponseEntity<Response> response = restTemplate.postForEntity(
                "http://localhost:" + port + "/api/message", request, Response.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getMessage()).contains("Message created with ID");
    }

    @Test
    public void getMessageShouldReturnNotFoundForInvalidId() {
        ResponseEntity<Message> response = restTemplate.getForEntity(
                "http://localhost:" + port + "/api/message/invalid-id", Message.class);
        
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
