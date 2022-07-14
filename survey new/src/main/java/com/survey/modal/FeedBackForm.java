package com.survey.modal;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedBackForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedId;
	
	private int formId = 60;
	
	private String email;

	private String feedback;

	private LocalDateTime time;
	
	private int userId;
	
	public FeedBackForm() {

	}
	
	public FeedBackForm(String email, String feedback, LocalDateTime time, int userId) {
		super();
		this.email = email;
		this.feedback = feedback;
		this.time = time;
		this.userId = userId;
	}
	
	public FeedBackForm(String feedback, LocalDateTime time) {
		super();
		this.feedback = feedback;
		this.time = time;
	}


	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
