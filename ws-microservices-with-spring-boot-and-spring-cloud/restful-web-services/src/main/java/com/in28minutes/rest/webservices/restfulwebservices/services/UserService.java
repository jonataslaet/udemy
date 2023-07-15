package com.in28minutes.rest.webservices.restfulwebservices.services;

import com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos.UserCreateDTO;
import com.in28minutes.rest.webservices.restfulwebservices.entities.User;
import com.in28minutes.rest.webservices.restfulwebservices.repositories.UserRepository;
import com.in28minutes.rest.webservices.restfulwebservices.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        User foundUser = userRepository.findOne(id);
        if (Objects.isNull(foundUser)) {
            throw new ResourceNotFoundException("User not found");
        }
        return foundUser;
    }

    public User saveUser(UserCreateDTO userCreateDTO) {
        User userToBeSaved = new User(userCreateDTO);
        return userRepository.save(userToBeSaved);
    }

    public void deleteUser(Integer id) {
        User foundUser = this.retriveUser(id);
        userRepository.delete(foundUser);
    }
}
