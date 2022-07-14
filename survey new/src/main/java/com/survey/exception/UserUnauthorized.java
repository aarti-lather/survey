package com.survey.exception;

public class UserUnauthorized extends RuntimeException{

	public UserUnauthorized() {
		
	}
	
	public UserUnauthorized(String message) {
		super(message);
	}
}
