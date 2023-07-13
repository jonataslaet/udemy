package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

    @GetMapping("/hello")
    public ResponseEntity<?> getHello() {
        String hello = "Hello, World!";
        return ResponseEntity.ok().body(hello);
    }

    @GetMapping("/hello-bean")
    public GreatingBean getHelloBean() {
        return new GreatingBean("Hello, World!");
    }

    @GetMapping("/hello-bean/{name}")
    public GreatingBean getHelloBeanByName(@PathVariable("name") String name) {
        return new GreatingBean(String.format("Hello, %s", name));
    }
}
