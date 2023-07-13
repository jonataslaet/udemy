package com.in28minutes.rest.webservices.restfulwebservices.controllers;

import com.in28minutes.rest.webservices.restfulwebservices.entities.User;
import com.in28minutes.rest.webservices.restfulwebservices.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> retrieveAllUsers() {
        return ResponseEntity.ok().body(userService.retriveAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable("id") Integer id) {
        return ResponseEntity.ok().body(userService.retriveUser(id));
    }
}