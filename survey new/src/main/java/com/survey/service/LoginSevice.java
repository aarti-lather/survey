package com.survey.service;

import com.survey.dto.UserLogIn;

public interface LoginSevice {

	public String userLogIn(UserLogIn userLogIn);
	
	public String userLogOut(String key);

}
