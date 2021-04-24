package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.dao.PersonRepository;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.PersonService;
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

    @Override
    public void addFriend(Person person) {
        personRepository.save(person);
    }

    @Override
    public void addPayment(String username, BigDecimal amount) {
        Optional<List<Person>> balance = getBalance();
        System.out.format("payer:%s - %.2f between %d\n",username, amount, balance.map(List::size).orElse(0));
        balance.ifPresent(list -> list.stream()
                .forEach(person -> {
                    System.out.format("BEFORE %s: %.2f\t\t",person.getUsername(), person.getBalance());
                    BigDecimal needToPay = amount.divide(BigDecimal.valueOf(list.size()), RoundingMode.HALF_UP);
                    if (person.getUsername().equals(username)){
                        needToPay = needToPay.subtract(amount);
                    }
                    person.setBalance(
                            person.getBalance()
                                    .add(needToPay));
                    personRepository.save(person);
                    System.out.format("AFTER %s: %.2f\n",person.getUsername(), person.getBalance());
                }));
        System.out.println("\n");
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
