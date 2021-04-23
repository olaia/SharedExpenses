package com.olaia.sharedexpenses.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="payer_id")
    private Person payer;
    private BigDecimal amount;
    private Instant date;

    public Expense(Person payer, BigDecimal amount, Instant date) {
        this.payer = payer;
        this.amount = amount;
        this.date = date;
    }

    public Person getPayer() {
        return payer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Instant getDate() {
        return date;
    }

    public static class Builder {
        private Person payer;
        private BigDecimal amount;
        private Instant date;

        public Builder(){}

        public Builder withPayer(Person payer){
            this.payer = payer;
            return this;
        }

        public Builder withAmount(BigDecimal amount){
            this.amount = amount;
            return this;
        }

        public Builder withDate(Instant date){
            this.date = date;
            return this;
        }

        public Expense build(){
            return new Expense(payer, amount, date);
        }
    }
}
