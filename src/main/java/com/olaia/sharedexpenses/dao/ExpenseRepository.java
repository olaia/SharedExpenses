package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
    @Override
    List<Expense> findAll();
}
