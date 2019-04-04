package com.user.info.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.model.User;
import com.user.info.service.IUserService;
import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

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
	
	@PostMapping(value="/image/upload")
	//@ResponseStatus(HttpStatus.CREATED)
	public ImgurResponseVO uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request, HttpServletResponse response) throws UserException {
		
		System.out.println("in controller");
		ImgurResponseVO imgurResponseVO=userService.uploadImage(file);
		return imgurResponseVO;
		
	}
	@GetMapping("/image/delete/{id}")
	public ImgurDeleteResponseVO deleteimage(@PathVariable("id") String id) throws UserException {
		
		ImgurDeleteResponseVO imgurDeleteResponseVO=userService.deleteImage(id);
		
		return imgurDeleteResponseVO;
		
		
	}
	@GetMapping("/image/view/{id}")
	public ImgurResponseVO viewImage(@PathVariable("id") String id) throws UserException {
		
		ImgurResponseVO imgurViewResponseVO=userService.viewImage(id);
		
		return imgurViewResponseVO;
	}
	
	
	
}
