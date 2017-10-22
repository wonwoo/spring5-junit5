package me.wonwoo.repository;

import me.wonwoo.domain.Person;
import me.wonwoo.memory.InMemoryRepository;

import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class PersonRepository extends InMemoryRepository<Person, UUID>{

  public Person findByname(String name) {
    return this.findAll().stream().filter(person -> person.getName().equals(name)).findFirst().orElse(null);
  }
}
