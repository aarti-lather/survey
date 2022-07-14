package com.survey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.modal.User;
import com.survey.repository.UserDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User signUp(User user) {
		userDao.save(user);		
		return user;
	}
	
	
	
	
	
	

}
