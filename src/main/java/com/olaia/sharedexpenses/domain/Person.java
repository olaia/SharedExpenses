package com.olaia.sharedexpenses.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
public class Person {
    @Id
    private String username;

    private String name;
    private String lastname;
    private BigDecimal balance;

    public Person(String username, String name, String lastname) {
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.balance = BigDecimal.ZERO;
    }

    public String getUsername() {
        return username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && lastname.equals(person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }

    public static class Builder{
        private String username;
        private String name;
        private String lastname;

        public Builder(){}

        public Person.Builder withUsername(String username){
            this.username = username;
            return this;
        }

        public Person.Builder withName(String name){
            this.name = name;
            return this;
        }

        public Person.Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }

        public Person build(){
            return new Person(username, name, lastname);
        }
    }
}
