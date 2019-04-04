package com.user.info.vo;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImgurDataVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String decription;
	private String datetime;
	private String type;
	private String deletehash;
	private String link;
	private String error;
	

}
