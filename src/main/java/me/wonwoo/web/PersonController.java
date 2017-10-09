package me.wonwoo.web;

import me.wonwoo.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

  @GetMapping("/persons")
  public List<Person> getPersons() {
    return Arrays.asList(new Person("wonwoo"), new Person("kevin"));
  }

  @GetMapping("/persons/{name}")
  public Person getPerson(@PathVariable String name) {
    return new Person(name);
  }
}
