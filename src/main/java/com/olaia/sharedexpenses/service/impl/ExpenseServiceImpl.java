package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Override
    public Optional<List<Expense>> findAll() {
        List<Expense> expenses = new ArrayList<>();
        Person person1 = new Person.Builder()
                                    .withName("Olaia")
                                    .withLastname("Segovia")
                                    .build();
        Instant instant = Instant.now();
        Expense expense1 = new Expense.Builder()
                                    .withPayer(person1)
                                    .withAmount(BigDecimal.TEN)
                                    .withDate(instant)
                                    .build();
        expenses.add(expense1);
        return Optional.ofNullable(expenses);
    }
}
