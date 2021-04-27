package com.olaia.sharedexpenses.service;

import com.olaia.sharedexpenses.domain.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface UserService {
    void addUser(User user);
    void addPayment(String username, BigDecimal amount);
    Optional<List<User>> getBalance();
    boolean userExists(String fullName);
    Optional<User> findByUsername(String username);
}
