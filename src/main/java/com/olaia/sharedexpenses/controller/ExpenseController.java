package com.olaia.sharedexpenses.controller;

import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/getAll")
    public ResponseEntity getExpenses() {
        Optional<List<Expense>> expenses = expenseService.findAll();
        return expenses.isPresent()
                ? ResponseEntity.ok(expenses)
                : ResponseEntity.notFound().build();
    }
}
