package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class GreetingsController {

    private final MessageSource messageSource;

    public GreetingsController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

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

    @GetMapping("/hello-internationalized")
    public ResponseEntity<?> getHelloInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return ResponseEntity.ok().body(messageSource.getMessage("greeting.message", null, "Default Message", locale));
    }

}
