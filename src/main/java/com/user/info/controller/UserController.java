package com.user.info.controller;

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
import com.user.info.vo.UserInfoVO;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private UserDTO userDTO;

	// this method is used to save new user details into database.
	@PostMapping("user/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createUser(@Validated @RequestBody User user) throws UserException {

		userDTO = new UserDTO();
		user.setPassWord(bCryptPasswordEncoder.encode(user.getPassWord()));
		userDTO.setUserVO(user);
		userService.createUser(userDTO);

	}

	// this method is used to interact with imgur API to upload image file
	@PostMapping(value = "/image/upload")
	public ImgurResponseVO uploadImage(@RequestParam("file") MultipartFile file) throws UserException {
		ImgurResponseVO imgurResponseVO = userService.uploadImage(file);
		return imgurResponseVO;

	}

	// this method will interact with imgur Api and used to delete image
	@GetMapping("/image/delete/{id}")
	public ImgurDeleteResponseVO deleteimage(@PathVariable("id") String id) throws UserException {

		ImgurDeleteResponseVO imgurDeleteResponseVO = userService.deleteImage(id);

		return imgurDeleteResponseVO;

	}

	// this method will interact with imgur Api and used to view image
	@GetMapping("/image/view/{id}")
	public ImgurResponseVO viewImage(@PathVariable("id") String id) throws UserException {

		ImgurResponseVO imgurViewResponseVO = userService.viewImage(id);

		return imgurViewResponseVO;
	}

	// this method will interact with h2 DataBase and used to fetch userBasic
	// information
	@GetMapping("/user/viewInfo/")
	public UserInfoVO viewInfo() throws UserException {

		String userName = "sai";

		return userService.viewInfo(userName);

	}

}
