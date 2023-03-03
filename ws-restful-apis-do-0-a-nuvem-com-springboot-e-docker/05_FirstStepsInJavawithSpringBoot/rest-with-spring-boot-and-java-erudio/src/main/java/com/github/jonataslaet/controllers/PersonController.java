package com.github.jonataslaet.controllers;

import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.services.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @RequestMapping(value = "/people/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public Person getPerson(@PathVariable(value = "personId") String personId) {
    return personService.findById(personId);
  }

  @RequestMapping(value = "/people", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getPeople() {
    return personService.findAll();
  }

  @RequestMapping(value = "/people/{personId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
  public Person updatePerson(@PathVariable(value = "personId") String personId, @RequestBody Person person) {
    return personService.updatePerson(personId, person);
  }

  @RequestMapping(value = "/people/{personId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
  public void deletePerson(@PathVariable(value = "personId") String personId) {
    personService.deletePerson(personId);
  }
}
