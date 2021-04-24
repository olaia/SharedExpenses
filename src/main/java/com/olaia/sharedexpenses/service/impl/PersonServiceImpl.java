package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.Application;
import com.olaia.sharedexpenses.dao.PersonRepository;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    static final Logger log = LoggerFactory.getLogger(Application.class);

    @Override
    public void addFriend(Person person) {
        personRepository.save(person);
    }

    @Override
    public void addPayment(String username, BigDecimal amount) {
        Optional<List<Person>> balance = getBalance();
        log.info(String.format("payer:%s - %.2f between %d",username, amount, balance.map(List::size).orElse(0)));
        balance.ifPresent(list -> list.stream()
                .forEach(person -> {
                    log.info(String.format("BEFORE \t%s: %.2f",person.getUsername(), person.getBalance()));
                    BigDecimal needToPay = amount.divide(BigDecimal.valueOf(list.size()), RoundingMode.HALF_UP);
                    if (person.getUsername().equals(username)){
                        needToPay = needToPay.subtract(amount);
                    }
                    person.setBalance(
                            person.getBalance()
                                    .add(needToPay));
                    personRepository.save(person);
                    log.info(String.format("AFTER \t%s: %.2f",person.getUsername(), person.getBalance()));
                }));
    }

    @Override
    public Optional<List<Person>> getBalance() {
        return Optional.ofNullable(personRepository.findAll());
    }

    @Override
    public boolean isFriend(String username) {
        return personRepository.existsById(username);
    }

    @Override
    public Optional<Person> findByUsername(String username) {
        return personRepository.findById(username);
    }
}
