package com.survey.service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.survey.dto.LoginSession;
import com.survey.dto.UserLogIn;
import com.survey.exception.UserUnauthorized;
import com.survey.modal.FeedBackForm;
import com.survey.modal.User;
import com.survey.repository.FormDao;
import com.survey.repository.LoginSessionDao;
import com.survey.repository.UserDao;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginSeviceImpl implements LoginSevice {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FormDao formDao;
	
	@Autowired
	private LoginSessionDao loginSessionDao;

	@Override
	public String userLogIn(UserLogIn userLogIn) {
		
		Optional<User> optional = userDao.findByEmail(userLogIn.getEmail());
		
		if(optional.isPresent()) {
			if(optional.get().getPassword().equals(userLogIn.getPassword())) {
				String key = RandomString.make(5);
				LoginSession loginSesion = new LoginSession(key, userLogIn.getEmail(), userLogIn.getPassword(), optional.get().getUserType());
				loginSessionDao.save(loginSesion);
				
				return "Login sucess";
			}
			else {
				throw new UserUnauthorized("Incorrect password");
			}
		}
		else {
			throw new UserUnauthorized("Email Not found");
		}
		
	}

	@Override
	public String userLogOut(String key) {
		loginSessionDao.deleteById(key);
		return "Logout successfull";
	}

}
