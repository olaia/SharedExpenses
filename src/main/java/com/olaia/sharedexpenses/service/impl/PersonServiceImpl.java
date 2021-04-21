package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final List<Person> group;

    public PersonServiceImpl() {
        group = new ArrayList<>();
    }

    public PersonServiceImpl(List<Person> group) {
        this.group = group;
    }

    @Override
    public void addFriend(Person person) {
        group.add(person);
    }

    @Override
    public Optional<List<Person>> findAll() {
        return Optional.ofNullable(group);
    }
}
