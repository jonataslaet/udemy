package com.in28minutes.rest.webservices.restfulwebservices.controllers;

public class GreatingBean {
    private String message;

    public GreatingBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
