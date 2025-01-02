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
    public void helloShouldReturnDefaultMessage(){
        String response = restTemplate.getForObject("http://localhost:"+port+"/hello", String.class);
        assertEquals("Hello CI/CD!", response);
    }
    @Test
    public void statusShouldReturnUpMessage(){
        String response= restTemplate.getForObject("http://localhost:"+port+"/status", String.class);
        assertEquals("Application is running!",response);
    }
    @Test
    public void nameShouldReturnDefaultMessage(){
        String response= restTemplate.getForObject("http://localhost:"+port+"/name", String.class);
        assertEquals("CI/CD Demo Application", response);
    }
    @Test
    public void versionShouldReturnTrue(){
        String response= restTemplate.getForObject("http://localhost:"+port+"/version", String.class);
        assertEquals("v1.0.0",response);
    }
    @Test
    public void dummyShouldReturnTrue(){
        String response= restTemplate.getForObject("http://localhost:"+port+"/dummy", String.class);
        assertEquals("dummy", response );
    }
}
