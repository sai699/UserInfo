package com.user.info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.user.info.dao.UserRepo;
import com.user.info.dto.UserDTO;
import com.user.info.exception.UserException;
import com.user.info.imgurservice.IImgurService;
import com.user.info.model.Images;
import com.user.info.model.User;
import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private IImgurService imgurService;
	
	@Autowired
	private UserRepo UserRepo;
	
	@Override
	public void createUser(UserDTO userDTO) throws UserException {
		
		userRepo.save(userDTO.getUserVO());
		
	}

	@Override
	public ImgurResponseVO uploadImage(MultipartFile file) {
		
		System.out.println("in user service");
		User user = null;
		ImgurResponseVO imgurResponseVO= imgurService.uploadImage(file);
		if(imgurResponseVO.getStatus().equals("200"))
	     user =userRepo.findByUserName("sai");
	    List<Images> images= new ArrayList<Images>();
	    Images image = new Images();
	    image.setImg_link(imgurResponseVO.getData().getLink());
	    images.add(image);
	    user.setImages(images);
	    userRepo.save(user);
		return imgurResponseVO;

		
	}

	@Override
	public ImgurResponseVO viewImage(String id) {
		
	  return imgurService.viewImage(id);
 		
	}

	@Override
	public ImgurDeleteResponseVO deleteImage(String id) {

		return imgurService.deleteImage(id);
	}

}
