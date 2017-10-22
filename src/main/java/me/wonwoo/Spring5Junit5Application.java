package me.wonwoo;

import me.wonwoo.domain.Person;
import me.wonwoo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Spring5Junit5Application {

  public static void main(String[] args) {
    SpringApplication.run(Spring5Junit5Application.class, args);
  }

  @Bean
  PersonRepository repository() {
    return new PersonRepository();
  }

  @Bean
  CommandLineRunner commandLineRunner(PersonRepository repository) {
    return args -> repository.save(Arrays.asList(
            new Person("wonwoo"),
            new Person("kevin")));
  }
}
