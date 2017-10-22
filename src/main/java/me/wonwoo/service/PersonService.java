package me.wonwoo.service;

import me.wonwoo.domain.Person;

class PersonService {

    Person getPerson(String name) {
        return new Person(name);
    }
}
