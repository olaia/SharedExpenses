package com.olaia.sharedexpenses.domain.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class ExpenseDTO {

    private String username;
    private BigDecimal amount;
    private Instant date;

    public ExpenseDTO() {
    }

    public ExpenseDTO(String username, BigDecimal amount, Instant date) {
        this.username = username;
        this.amount = amount;
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
