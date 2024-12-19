package org.allisra.cicddemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void HelloShouldReturnDefaultMessage(){
        String response = restTemplate.getForObject("http://localhost:"+port+"/hello", String.class);
        assertEquals("Hello CI/CD!", response);
    }
    @Test
    public void statusShouldReturnUpMessage(){
        String response= restTemplate.getForObject("http://localhost:"+port+"/status", String.class);
        assertEquals("Application is running!",response);
    }
}
