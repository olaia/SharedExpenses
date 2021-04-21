package com.olaia.sharedexpenses.service;

import com.olaia.sharedexpenses.domain.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    Optional<List<Expense>> findAll();
}
