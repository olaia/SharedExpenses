package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.service.ExpenseService;
import com.olaia.sharedexpenses.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    PersonService personService;

    private final List<Expense> expenses;

    public ExpenseServiceImpl() {
        expenses = new ArrayList<>();
    }

    @Override
    public Optional<List<Expense>> findAll() {
        return Optional.ofNullable(expenses);
    }

    @Override
    public void addExpense(Expense expense) {
        expenses.add(expense);

        personService.addPayment(expense.getPayer(), expense.getAmount());
        personService.getBalance().ifPresent(list -> list.stream()
                .forEach(person -> person.setBalance(
                        person.getBalance()
                                .add(expense.getAmount().divide(BigDecimal.valueOf(list.size()))))));
    }

}
