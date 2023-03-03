package com.github.jonataslaet.services;

import com.github.jonataslaet.entities.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final AtomicLong counter = new AtomicLong();

  private final Logger logger = Logger.getLogger(PersonService.class.getName());

  public Person findById(String id) {
    logger.info("Finding one person!");
    return mockPerson(Integer.parseInt(id));
  }

  public List<Person> findAll() {
    logger.info("Finding all people!");
    List<Person> allPeople = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      allPeople.add(mockPerson(i));
    }
    return allPeople;
  }

  private Person mockPerson(int id) {
    Person person = new Person();
    person.setId(counter.incrementAndGet());
    person.setFirstName("First Name " + id);
    person.setLastName("Last Name " + id);
    person.setAddress("Rua " + id);
    person.setGender("Male");
    return person;
  }

  public Person updatePerson(String personId, Person updatedPerson) {
    Person foundPerson = mockPerson(Integer.parseInt(personId));
    foundPerson.setAddress(updatedPerson.getAddress());
    foundPerson.setGender(updatedPerson.getGender());
    foundPerson.setFirstName(updatedPerson.getFirstName());
    foundPerson.setLastName(updatedPerson.getLastName());
    return foundPerson;
  }

  public void deletePerson(String personId) {
    Person foundPerson = mockPerson(Integer.parseInt(personId));
    foundPerson = null;
  }
}
