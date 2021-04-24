package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Override
    List<Expense> findAll();

    List<Expense> findAllByOrderByDateDesc();
}
