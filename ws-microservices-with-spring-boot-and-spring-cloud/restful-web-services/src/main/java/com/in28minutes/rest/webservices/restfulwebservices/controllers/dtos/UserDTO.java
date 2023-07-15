package com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserDTO {

    private Integer id;

    @Size(min = 2, message = "name must be at least 2 characters")
    private String name;

    @Past(message = "birth day must be in the past")
    private LocalDate birthDate;

    public UserDTO(){

    }

    public UserDTO(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
