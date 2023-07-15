package com.in28minutes.rest.webservices.restfulwebservices.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"id"})
public class UserCreateDTO extends UserDTO {

}
