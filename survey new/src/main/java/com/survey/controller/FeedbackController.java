package com.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.survey.dto.FeedBackResponse;
import com.survey.modal.FeedBackForm;
import com.survey.service.FeedbackServiceImpl;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackServiceImpl feedbackServiceImpl;
	
	@GetMapping("/createfeedbackform") 
	public ResponseEntity<String> createFeedBackForm(@RequestParam String key) {
		String response = feedbackServiceImpl.createFeedBackForm(key);
		return new ResponseEntity<String>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/edit")
	public ResponseEntity<FeedBackForm> editFeedbackForm(@RequestBody FeedBackResponse feedBackResponse){
		FeedBackForm feedBackResponse1 = feedbackServiceImpl.editFeedbackForm(feedBackResponse.getKey(), feedBackResponse.getMessage(), feedBackResponse.getFormId(), feedBackResponse.getEmail());
		
		return new ResponseEntity<FeedBackForm>(feedBackResponse1, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/review")
	public ResponseEntity<List<FeedBackForm>> reviewFeedBackForm(String key) {
		List<FeedBackForm> listsBackForms = feedbackServiceImpl.reviewFeedbackForm(key);
		
		return new ResponseEntity<List<FeedBackForm>>(listsBackForms, HttpStatus.FOUND);
	}
	
	
	@PostMapping("/feedbackresponse")
	public ResponseEntity<FeedBackForm> fillFeedbackForm(@RequestBody FeedBackResponse feedBackResponse){
		FeedBackForm feedBackResponse1 = feedbackServiceImpl.fillFeedbackForm(feedBackResponse.getKey(), feedBackResponse.getMessage(), feedBackResponse.getFormId());
		
		return new ResponseEntity<FeedBackForm>(feedBackResponse1, HttpStatus.ACCEPTED);
	}
}
