package com.user.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.info.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
