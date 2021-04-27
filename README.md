# Shared Expenses

<em>This README in other languages: [English](README.md), [Español](README.es.md).</em>

Shared Expenses is a backend application created with Spring Boot.

Dependencies have been managed with Gradle.

Shared Expenses is an application that provides support for group of friends that want to share expenses and keep track of what each one owes to/from the group.
Data is stored in MySQL database.


# Features
1. Add User
    1. Username (Required field)
    2. Name
    3. Lastname
2. List All Users
    1. Username
    2. Name
    3. Lastname
    4. Balance (Amount owned to/from the group, in €uros) 
3. Add Expense
    1. Username (Required field)
    2. Amount (Required field, in €uros)
    3. Description
4. List All Expenses
    1. Username
    2. Amount (In €uros)
    3. Description
    4. Date

## Requirements
1. [Java(11)](java.com/)

## Usage
Starting the server application.
```
java -jar ./build/libs/SharedExpenses-0.0.1-SNAPSHOT.jar
```

## Compilation
Source code compilation.
```
./gradlew build
```
Compilation and execution
```
./gradlew bootRun
```

## Data Persistance
Data is persisted via Spring Data, using JPA.
MySQL database has been used. It is provided a sample copy in the source code so devs can test the app.

## Import the database
A sample DB is provided. Could be imported as follows.
```
mysql --user=springuser --password=ThePassword -h localhost shared_expenses < shared_expenses.sql 
```

## Assumptions
1. Username field is required. It is used as a user identifier. 
   This way we can have people that share a name and lastname.
2. If user has a negative balance, it means the group owes the user money. The group is in debt.
3. User might update name and lastname, balance and username is kept.
4. Currency is always €uros.

## Technical Decisions
1. Back and front exchange times in EPOCH format. Database stores user readable string.

## Nice to have
1. Tests. To ensure correct back behaviour and proyect scalability.
2. Docker containers allowing a developer to package up an application with all the needed parts, such as libraries and other dependencies, and ship it all out as one package.
3. Nominal expense. App would tell each person how much to pay and to whom in order to keep the group balance to 0€.
