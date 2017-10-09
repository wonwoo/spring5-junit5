package me.wonwoo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

  @Id
  private Long id;

  private String name;

  Customer() {
  }

  public Customer(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
