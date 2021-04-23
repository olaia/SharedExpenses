package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.dao.PersonRepository;
import com.olaia.sharedexpenses.domain.Friends;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addFriend(Person person) {
        personRepository.save(person);
    }

    @Override
    public void addPayment(String personName, BigDecimal amount) {
//        Person payer = group.getPerson(personName);
//        if (payer != null)
//            payer.setBalance(payer.getBalance().subtract(amount));
    }

    @Override
    public Optional<List<Person>> getBalance() {
        return Optional.ofNullable(new ArrayList<>());// Optional.ofNullable(group.getList());
    }

    @Override
    public boolean isFriend(String fullName) {
        return false;//group.isFriend(fullName);
    }
}
