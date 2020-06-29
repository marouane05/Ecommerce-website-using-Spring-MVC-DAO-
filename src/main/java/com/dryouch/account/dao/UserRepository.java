package com.dryouch.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dryouch.account.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
