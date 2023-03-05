package com.github.jonataslaet.controllers;

import com.github.jonataslaet.data.vo.v1.PersonVO;
import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/people")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO getPerson(@PathVariable(value = "personId") String personId) {
    return personService.findById(Long.valueOf(personId));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<PersonVO> getPeople() {
    return personService.findAll();
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO createPerson(@RequestBody PersonVO personVO) {
    return personService.createPerson(personVO);
  }

  @PutMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public PersonVO updatePerson(@PathVariable(value = "personId") String personId, @RequestBody PersonVO person) {
    return personService.updatePerson(Long.valueOf(personId), person);
  }

  @DeleteMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> deletePerson(@PathVariable(value = "personId") String personId) {
    personService.deletePerson(Long.valueOf(personId));
    return ResponseEntity.noContent().build();
  }
}
