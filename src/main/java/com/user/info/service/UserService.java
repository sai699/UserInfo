package com.user.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.info.dao.UserRepo;
import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public void createUser(UserDTO userDTO) throws UserException {
		
		userRepo.save(userDTO.getUserVO());
		
	}

}
