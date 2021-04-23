package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

}
