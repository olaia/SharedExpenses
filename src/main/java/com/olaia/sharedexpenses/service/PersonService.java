package com.olaia.sharedexpenses.service;

import com.olaia.sharedexpenses.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    void addFriend(Person person);
    Optional<List<Person>> findAll();
}
