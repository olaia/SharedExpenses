package com.olaia.sharedexpenses.domain.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class ExpenseDTO {

    private String fullName;
    private BigDecimal amount;
    private Instant date;

    public ExpenseDTO(String fullName, BigDecimal amount, Instant date) {
        this.fullName = fullName;
        this.amount = amount;
        this.date = date;
    }

    public String getFullName() {
        return fullName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
