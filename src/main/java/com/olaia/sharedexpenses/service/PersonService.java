package com.olaia.sharedexpenses.service;

import com.olaia.sharedexpenses.domain.Person;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    void addFriend(Person person);
    void addPayment(Person person, BigDecimal amount);
    Optional<List<Person>> getBalance();
}
