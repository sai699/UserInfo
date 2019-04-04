package com.user.info.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.user.info.model.Images;
import com.user.info.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoVO  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String phoneNumber;
	private Set<Role> roles;
	private List<Images> images;

}
