package me.wonwoo.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CustomerRepositoryTests {

  @Test
  @Sql("/init.sql")
  @DisplayName("👍")
  void findTest(@Autowired CustomerRepository repository) {
    Customer customer = repository.findByName("wonwoo");
    assertThat(customer.getName()).isEqualTo("wonwoo");
  }
}