package me.wonwoo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import me.wonwoo.domain.Person;
import me.wonwoo.mockito.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class PersonServiceTests {

    @BeforeEach
    void setup(@Mock PersonService personService) {
        given(personService.getPerson(any())).willReturn(new Person("wonwoo"));
    }

    @Test
    @DisplayName("mockito extension")
    void getPerson(@Mock PersonService personService) {
        Person person = personService.getPerson("wonwoo");
        assertThat(person).isEqualTo(new Person("wonwoo"));
    }
}