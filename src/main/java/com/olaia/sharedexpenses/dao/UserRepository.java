package com.olaia.sharedexpenses.dao;

import com.olaia.sharedexpenses.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    List<User> findAll();
}
