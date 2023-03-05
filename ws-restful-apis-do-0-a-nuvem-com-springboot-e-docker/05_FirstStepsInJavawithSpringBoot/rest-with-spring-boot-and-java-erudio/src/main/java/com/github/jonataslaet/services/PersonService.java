package com.github.jonataslaet.services;

import com.github.jonataslaet.data.vo.v1.PersonVO;
import com.github.jonataslaet.entities.Person;
import com.github.jonataslaet.exceptions.ResourceNotFoundException;
import com.github.jonataslaet.repositories.PersonRepository;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final Logger logger = Logger.getLogger(PersonService.class.getName());

  @Autowired
  PersonRepository personRepository;

  @Autowired
  private ModelMapper mapper;

  public PersonVO findById(Long id) {
    logger.info("Finding one person!");
    return mapper.map(getPersonById(id), PersonVO.class);
  }

  public List<PersonVO> findAll() {
    logger.info("Finding all people!");
    return personRepository.findAll().stream().map(person ->
        mapper.map(person, PersonVO.class)).toList();
  }

  public PersonVO updatePerson(Long personId, PersonVO updatedPerson) {
    logger.info("Updating a person!");
    Person foundPersonToBeUpdated = getPersonById(personId);
    foundPersonToBeUpdated.setId(personId);
    foundPersonToBeUpdated.setAddress(updatedPerson.getAddress());
    foundPersonToBeUpdated.setGender(updatedPerson.getGender());
    foundPersonToBeUpdated.setFirstName(updatedPerson.getFirstName());
    foundPersonToBeUpdated.setLastName(updatedPerson.getLastName());
    return mapper.map(personRepository.save(foundPersonToBeUpdated), PersonVO.class);
  }

  public PersonVO createPerson(PersonVO newPerson) {
    logger.info("Create a person!");
    Person person = mapper.map(newPerson, Person.class);
    return mapper.map(personRepository.save(person), PersonVO.class);
  }

  public void deletePerson(Long personId) {
    logger.info("Delete a person!");
    getPersonById(personId);
    personRepository.deleteById(personId);
  }

  private Person getPersonById(Long id) {
    return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No person found for this ID!"));
  }
}
