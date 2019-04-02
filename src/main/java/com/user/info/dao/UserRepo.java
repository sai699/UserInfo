package com.user.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.info.model.User;

public interface UserRepo extends JpaRepository<User, String>  {

	 User findByUserName(String username);

}
