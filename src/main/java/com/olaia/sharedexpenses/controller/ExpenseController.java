package com.olaia.sharedexpenses.controller;

import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.service.ExpenseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gastos")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/listar")
    public ResponseEntity getExpenses() {
        Optional<List<Expense>> expenses = expenseService.findAll();
        return expenses.isPresent()
                ? ResponseEntity.ok(expenses.get())
                : ResponseEntity.notFound().build();
    }
}
