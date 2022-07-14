package com.survey.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FeedbackFormCreatedByCoordinator {
	
	@Id
	private int UserId;
	
	private int formId;
	
	public FeedbackFormCreatedByCoordinator() {
		super();
	}

	public FeedbackFormCreatedByCoordinator(int userId, int formId) {
		super();
		UserId = userId;
		this.formId = formId;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}
	
	

}
