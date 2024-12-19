package org.allisra.cicddemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello CI/CD!";
    }
    @GetMapping("/status")
    public String status(){
        return "Application is running!";
    }
    @GetMapping("/name")
    public String name(){
        return "CI/CD Demo Application";
    }
    @GetMapping("/version")
    public String getVersion(){
        return "v1.0.0";
    }
}
