package com.user.info.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int user_id;
	@NotEmpty
	@NotNull
	private String userName;
	@NotEmpty
	@NotNull
	private String passWord;
	@Email
	private String email;
	@NotEmpty
	@NotNull
	private String phoneNumber;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name="user_role", joinColumns = @JoinColumn(name ="user_id") , inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
}
