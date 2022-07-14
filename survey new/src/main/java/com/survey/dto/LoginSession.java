package com.survey.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.survey.modal.UserType;


@Entity
public class LoginSession {

	@Id
	private String uuid;
	private String email;
	private String password;
	
	private UserType userType;
	
	
	public LoginSession() {
		super();
	}
	public LoginSession(String uuid, String email, String password,UserType userType) {
		super();
		this.uuid = uuid;
		this.email = email;
		this.password = password;
		this.userType = userType;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	
}
