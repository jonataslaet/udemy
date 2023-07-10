package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        String hello = "Hello, World!";
        return ResponseEntity.ok().body(hello);
    }
}
