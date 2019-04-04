package com.user.info.service;

import org.springframework.web.multipart.MultipartFile;

import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

public interface IUserService {

	public void createUser(UserDTO userDTO) throws UserException;
	public ImgurResponseVO uploadImage(MultipartFile file);
	public ImgurResponseVO viewImage(String id);
	public ImgurDeleteResponseVO deleteImage(String id);
	
}
