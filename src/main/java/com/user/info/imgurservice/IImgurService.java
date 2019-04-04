package com.user.info.imgurservice;

import org.springframework.web.multipart.MultipartFile;

import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

public interface IImgurService {

	public ImgurResponseVO uploadImage(MultipartFile file);
	public ImgurResponseVO viewImage(String id);
	public ImgurDeleteResponseVO deleteImage(String id);
	
}
