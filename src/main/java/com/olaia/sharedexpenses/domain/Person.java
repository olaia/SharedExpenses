package com.olaia.sharedexpenses.domain;

import java.math.BigDecimal;

public class Person {
    private String name;
    private String lastname;
    private BigDecimal balance;

    public Person(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.balance = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static class Builder{
        private String name;
        private String lastname;
        private BigDecimal balance;

        public Builder(){}

        public Person.Builder withName(String name){
            this.name = name;
            return this;
        }

        public Person.Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }

        public Person build(){
            return new Person(name, lastname);
        }
    }
}
