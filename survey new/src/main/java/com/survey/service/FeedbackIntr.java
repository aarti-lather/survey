package com.survey.service;

import java.util.List;

import com.survey.modal.FeedBackForm;

public interface FeedbackIntr {
	
	public String createFeedBackForm(String key);
	public FeedBackForm editFeedbackForm(String key, String message, int formId, String email);
	public List<FeedBackForm> reviewFeedbackForm(String key);

	public FeedBackForm fillFeedbackForm(String key, String message, int formId);
}
