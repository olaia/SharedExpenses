package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Expense;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
}
