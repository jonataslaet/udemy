package com.github.jonataslaet.controllers;

import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
  public Person getPerson(@PathVariable(value = "personId") String personId) {
    return personService.findById(Long.valueOf(personId));
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getPeople() {
    return personService.findAll();
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Person createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }

  @PutMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Person updatePerson(@PathVariable(value = "personId") String personId, @RequestBody Person person) {
    return personService.updatePerson(Long.valueOf(personId), person);
  }

  @DeleteMapping(value = "/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public void deletePerson(@PathVariable(value = "personId") String personId) {
    personService.deletePerson(Long.valueOf(personId));
  }
}
