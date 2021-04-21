package com.olaia.sharedexpenses.domain;

import java.math.BigDecimal;
import java.time.Instant;

public class Expense {
    private Person payer;
    private BigDecimal balance;
    private Instant date;

    public Expense(Person payer, BigDecimal balance, Instant date) {
        this.payer = payer;
        this.balance = balance;
        this.date = date;
    }

    public static class Builder {
        private Person payer;
        private BigDecimal balance;
        private Instant date;

        public Builder(){}

        public Builder withPayer(Person payer){
            this.payer = payer;
            return this;
        }

        public Builder withBalance(BigDecimal balance){
            this.balance = balance;
            return this;
        }

        public Builder withDate(Instant date){
            this.date = date;
            return this;
        }

        public Expense build(){
            return new Expense(payer, balance, date);
        }
    }
}
