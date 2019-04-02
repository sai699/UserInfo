package com.user.info.service;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;

public interface IUserService {

	public void createUser(UserDTO userDTO) throws UserException;
	
}
