package me.wonwoo.domain;


import me.wonwoo.memory.Entity;

import java.util.UUID;

public class Person implements Entity<UUID> {

  private String name;
  private UUID id;

  Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public UUID getId() {
    return this.id;
  }

  @Override
  public void setId(UUID id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    return id != null ? id.equals(person.getId()) : person.getId() == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", id=" + id +
        '}';
  }


}
