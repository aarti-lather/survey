package com.survey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.survey.modal.User;
import com.survey.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<String> hii() {
		return  new ResponseEntity<String>("Welcome to survey", HttpStatus.OK);
	}
	
	@PostMapping("/user/signup")
	public ResponseEntity<User> signUp(@RequestBody User user){
		User signUpUser = userService.signUp(user);
		return new ResponseEntity<User>(signUpUser, HttpStatus.ACCEPTED);
		
	}
	
}
