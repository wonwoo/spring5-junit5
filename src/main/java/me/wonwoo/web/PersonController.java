package me.wonwoo.web;

import me.wonwoo.domain.Person;
import me.wonwoo.repository.PersonRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

  private final PersonRepository personRepository;

  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @GetMapping("/persons")
  public List<Person> getPersons() {
    return personRepository.findAll();
  }

  @GetMapping("/persons/{name}")
  public Person getPerson(@PathVariable String name) {
    return personRepository.findByname(name);
  }
}
