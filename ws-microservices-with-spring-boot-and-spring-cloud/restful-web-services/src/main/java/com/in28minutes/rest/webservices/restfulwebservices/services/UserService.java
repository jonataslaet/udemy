package com.in28minutes.rest.webservices.restfulwebservices.services;

import com.in28minutes.rest.webservices.restfulwebservices.entities.User;
import com.in28minutes.rest.webservices.restfulwebservices.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> retriveAllUsers() {
        return userRepository.findAll();
    }

    public User retriveUser(Integer id) {
        return userRepository.findOne(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
