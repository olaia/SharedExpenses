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
    private String description;

    public Expense(){}

    public Expense(Person payer, BigDecimal amount, Instant date, String description) {
        this.payer = payer;
        this.amount = amount;
        this.date = date;
        this.description = description;
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

    public void setPayer(Person payer){
        this.payer = payer;
    }

    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    public void setDate(Instant date){
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static class Builder {
        private Person payer;
        private BigDecimal amount = BigDecimal.ZERO;
        private Instant date;
        private String description;

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

        public Builder withDescription(String description){
            this.description = description;
            return this;
        }

        public Expense build(){
            return new Expense(payer, amount, date, description);
        }
    }
}
