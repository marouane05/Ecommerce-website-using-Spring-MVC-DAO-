package com.dryouch.account.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dryouch.account.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
