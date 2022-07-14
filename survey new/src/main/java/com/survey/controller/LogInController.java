package com.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.survey.dto.UserLogIn;
import com.survey.service.LoginSeviceImpl;

@RestController
public class LogInController {

	@Autowired
	private LoginSeviceImpl  loginSeviceImpl;
	
	@PostMapping("/login")
	public ResponseEntity<String> userLogIn(@RequestBody UserLogIn userLogIn){
		String result= loginSeviceImpl.userLogIn(userLogIn);	
		
		return new ResponseEntity<String>(result, HttpStatus.ACCEPTED);
		
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> userLogOut (@RequestParam String key){
		String response = loginSeviceImpl.userLogOut(key);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
}
