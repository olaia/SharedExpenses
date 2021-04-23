package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.domain.Friends;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final Friends group = new Friends();

    @Override
    public void addFriend(Person person) {
        group.addFriend(person);
    }

    @Override
    public void addPayment(String personName, BigDecimal amount) {
        Person payer = group.getPerson(personName);
        if (payer != null)
            payer.setBalance(payer.getBalance().subtract(amount));
    }

    @Override
    public Optional<List<Person>> getBalance() {
        return Optional.ofNullable(group.getList());
    }

    @Override
    public boolean isFriend(String fullName) {
        return group.isFriend(fullName);
    }
}
