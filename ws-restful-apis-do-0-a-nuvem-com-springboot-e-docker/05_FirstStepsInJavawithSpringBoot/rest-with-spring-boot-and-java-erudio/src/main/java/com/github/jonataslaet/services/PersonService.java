package com.github.jonataslaet.services;

import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.exceptions.ResourceNotFoundException;
import com.github.jonataslaet.repositories.PersonRepository;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  public Person findById(Long id) {
    logger.info("Finding one person!");
    return getPersonById(id);
  }

  public List<Person> findAll() {
    logger.info("Finding all people!");
    return personRepository.findAll();
  }

  public Person updatePerson(Long personId, Person updatedPerson) {
    logger.info("Updating a person!");
    Person foundPersonToBeUpdated = getPersonById(personId);
    foundPersonToBeUpdated.setId(personId);
    foundPersonToBeUpdated.setAddress(updatedPerson.getAddress());
    foundPersonToBeUpdated.setGender(updatedPerson.getGender());
    foundPersonToBeUpdated.setFirstName(updatedPerson.getFirstName());
    foundPersonToBeUpdated.setLastName(updatedPerson.getLastName());
    return personRepository.save(foundPersonToBeUpdated);
  }

  public Person createPerson(Person newPerson) {
    logger.info("Create a person!");
    return personRepository.save(newPerson);
  }

  public void deletePerson(Long personId) {
    logger.info("Delete a person!");
    Person foundPerson = getPersonById(personId);
    personRepository.deleteById(foundPerson.getId());
  }

  private Person getPersonById(Long id) {
    return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No person found for this ID!"));
  }
}
