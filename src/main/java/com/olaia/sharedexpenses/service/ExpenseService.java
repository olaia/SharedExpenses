package com.olaia.sharedexpenses.service;

import com.olaia.sharedexpenses.domain.dto.ExpenseDTO;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    void addExpense(ExpenseDTO expenseDTO);
    Optional<List<ExpenseDTO>> findAll();
}
