package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final List<Person> group;
//    private final HashMap<Person> friends;

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
    public void addPayment(Person person, BigDecimal amount) {
        int idx = group.indexOf(person);
        Person payer = group.get(idx);
        if (payer != null)
            payer.setBalance(payer.getBalance().subtract(amount));
    }

    @Override
    public Optional<List<Person>> getBalance() {
        return Optional.ofNullable(group);
    }
}
