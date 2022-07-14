package com.survey.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserUnauthorized.class) 
	public ResponseEntity<MyErrorMessage> userUnauthorised(UserUnauthorized userUnauthorized, WebRequest webRequest) {
		
		MyErrorMessage error = new MyErrorMessage(userUnauthorized.getMessage(), LocalDateTime.now(), webRequest.getDescription(false));
		
		return new ResponseEntity<MyErrorMessage>(error, HttpStatus.BAD_REQUEST);
	}
	
	
}
