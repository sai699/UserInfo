package com.user.info.dto;

import java.io.Serializable;

import com.user.info.model.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User userVO;
	
	
	

}
