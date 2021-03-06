package com.user.info.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Images {
	
	@Id
	@GeneratedValue
	private int img_id;
	private String img_link;

}
