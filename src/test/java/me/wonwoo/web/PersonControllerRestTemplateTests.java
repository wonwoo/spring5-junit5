package me.wonwoo.web;

import me.wonwoo.domain.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PersonControllerRestTemplateTests {

  private final TestRestTemplate template;

  @Autowired
  PersonControllerRestTemplateTests(TestRestTemplate template) {
    this.template = template;
  }

  @Test
  void person() {
    Person person = template.getForEntity("/persons/{name}", Person.class, "wonwoo").getBody();
    assertThat(person).isEqualTo(new Person("wonwoo"));
  }
}