package com.olaia.sharedexpenses.controller;

import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.domain.Person;
import com.olaia.sharedexpenses.domain.dto.ExpenseDTO;
import com.olaia.sharedexpenses.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;

    @GetMapping("/getAll")
    public ResponseEntity getExpenses() {
        Optional<List<ExpenseDTO>> expenses = expenseService.findAll();
        return expenses.isPresent()
                ? ResponseEntity.ok(expenses)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/addExpense")
    public ResponseEntity addExpense(@RequestBody ExpenseDTO expense) {
        expenseService.addExpense(expense);
        return ResponseEntity.ok().build();
    }
}
