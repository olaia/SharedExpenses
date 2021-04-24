package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, String> {
    @Override
    List<Person> findAll();
}
