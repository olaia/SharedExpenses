package com.olaia.sharedexpenses.service.impl;

import com.olaia.sharedexpenses.dao.ExpenseRepository;
import com.olaia.sharedexpenses.domain.Expense;
import com.olaia.sharedexpenses.domain.User;
import com.olaia.sharedexpenses.domain.dto.ExpenseDTO;
import com.olaia.sharedexpenses.service.ExpenseService;
import com.olaia.sharedexpenses.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @Override
    public Optional<List<ExpenseDTO>> findAll() {
//        expenseRepository.findAllByOrderByDate();
        List<Expense> expenses = expenseRepository.findAllByOrderByDateDesc();
        return Optional.ofNullable(expenses.stream().map(this::convertToDTO).collect(Collectors.toList()));
    }

    @Override
    public void addExpense(ExpenseDTO expenseDTO) {
        Expense expense = convertToEntity(expenseDTO);
        if (!userService.isFriend(expense.getPayer().getUsername())) return;

        expenseRepository.save(expense);
        userService.addPayment(expense.getPayer().getUsername(), expense.getAmount());
    }

    private ExpenseDTO convertToDTO(Expense expense) {
        ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
        expenseDTO.setUsername(expense.getPayer().getUsername());
        return expenseDTO;
    }

    private Expense convertToEntity(ExpenseDTO expenseDTO) {
        Expense expense = modelMapper.map(expenseDTO, Expense.class);
        expense.setPayer(new User.Builder().withUsername(expenseDTO.getUsername()).build());
        return expense;
    }
}
