package com.user.info.service;

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
import com.user.info.util.ApplicationConstants;
import com.user.info.vo.ImgurDeleteResponseVO;
import com.user.info.vo.ImgurResponseVO;
import com.user.info.vo.UserInfoVO;

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
	public ImgurResponseVO uploadImage(MultipartFile file, String userName) throws UserException {
		
		User user = null;
		ImgurResponseVO imgurResponseVO= imgurService.uploadImage(file);
		if(imgurResponseVO.getStatus().equals(ApplicationConstants.SUCCESS_CODE)) {
	    user =userRepo.findByUserName(userName);
		List<Images> images= user.getImages();
	    Images image = new Images();
	    image.setImg_link(imgurResponseVO.getData().getLink());
	   // image.setUser_id(user.getUser_id());
	    images.add(image);
	    user.setImages(images);
	    userRepo.save(user);
		}
		return imgurResponseVO;

	}

	@Override
	public ImgurResponseVO viewImage(String id) throws  UserException {
		
	  return imgurService.viewImage(id);
 		
	}
	@Override
	public ImgurDeleteResponseVO deleteImage(String id) throws UserException {

		return imgurService.deleteImage(id);
	}
	
	@Override
	public UserInfoVO viewInfo(String userName) throws UserException {
		
		User user =userRepo.findByUserName(userName);
		return prepareViewInfo(user);
	}
	//this method used to prepare userInfo Data
	private UserInfoVO prepareViewInfo(User user)  {
		
		UserInfoVO userInfoVO = new UserInfoVO();
		userInfoVO.setUserName(user.getUserName());
		userInfoVO.setPhoneNumber(user.getPhoneNumber());
		userInfoVO.setEmail(user.getEmail());
		userInfoVO.setRoles(user.getRoles());
		userInfoVO.setImages(user.getImages());
		
	return userInfoVO;    
	}

	

}
