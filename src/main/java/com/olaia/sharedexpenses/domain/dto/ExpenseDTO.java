package com.olaia.sharedexpenses.domain.dto;

import java.math.BigDecimal;

public class ExpenseDTO {

    private String username;
    private BigDecimal amount;
    private long date;
    private String description;

    public ExpenseDTO() {
    }

    public ExpenseDTO(String username, BigDecimal amount, long date, String description) {
        this.username = username;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getDate() {
        return date;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setDate(long dateEpoch) {
        this.date = dateEpoch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
