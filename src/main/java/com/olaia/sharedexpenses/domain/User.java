package com.olaia.sharedexpenses.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class User {
    @Id
    private String username;

    private String name;
    private String lastname;
    private BigDecimal balance;

    public User() {
        this.balance = BigDecimal.ZERO;
    }

    public User(String username, String name, String lastname) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && lastname.equals(user.lastname);
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

        public User.Builder withUsername(String username){
            this.username = username;
            return this;
        }

        public User.Builder withName(String name){
            this.name = name;
            return this;
        }

        public User.Builder withLastname(String lastname){
            this.lastname = lastname;
            return this;
        }

        public User build(){
            return new User(username, name, lastname);
        }
    }
}
