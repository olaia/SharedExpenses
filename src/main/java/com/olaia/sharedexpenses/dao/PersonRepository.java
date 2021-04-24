package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, String> {
    @Override
    List<Person> findAll();
}
