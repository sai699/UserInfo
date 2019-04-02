package com.user.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.model.User;
import com.user.info.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	private UserDTO userDTO;
	
	//this method is used to save new user details into database.
	@PostMapping("user/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@Validated@RequestBody User user) throws UserException {
		
		userDTO = new UserDTO();
		user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
		userDTO.setUserVO(user);
		userService.createUser(userDTO);
		
		
	}
	
	@GetMapping("/image/upload")
	@ResponseStatus(HttpStatus.CREATED)
	public void uploadImage() throws UserException {
		
		System.out.println("Authenticated and running");
		
	}
	
}
