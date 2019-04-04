package com.user.info.imgurservice;

import org.springframework.web.multipart.MultipartFile;

import com.user.info.exception.UserException;
import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

public interface IImgurService {

	public ImgurResponseVO uploadImage(MultipartFile file) throws UserException;
	public ImgurResponseVO viewImage(String id) throws UserException;
	public ImgurDeleteResponseVO deleteImage(String id) throws UserException;
	
}
