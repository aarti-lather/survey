package com.survey.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.dto.FeedbackFormCreatedByCoordinator;
import com.survey.dto.LoginSession;
import com.survey.exception.UserUnauthorized;
import com.survey.modal.FeedBackForm;
import com.survey.modal.User;
import com.survey.modal.UserType;
import com.survey.repository.FeedbackFormByCoordinatorDao;
import com.survey.repository.FormDao;
import com.survey.repository.LoginSessionDao;
import com.survey.repository.UserDao;


@Service
public class FeedbackServiceImpl implements FeedbackIntr{
	
	@Autowired
	private FormDao formDao;
	
	@Autowired
	private LoginSessionDao loginSessionDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private FeedbackFormByCoordinatorDao feedbackFormByCoordinatorDao;

	@Override
	public String createFeedBackForm(String key) {
		Optional<LoginSession> optional = loginSessionDao.findById(key);
		if(!optional.isPresent()) {
			throw new UserUnauthorized("Login first!! unautorised");
		}
		else {
						
			if(optional.get().getUserType().equals(UserType.RESPONDENT)) {
				throw new UserUnauthorized("You are not authorised");
			}
			else {
				Optional<User> userOptional = userDao.findByEmail(optional.get().getEmail());
				Optional<FeedBackForm> optional2 = formDao.getByUserId(userOptional.get().getUserId());
				
				if(optional2.isPresent()) {
					throw new UserUnauthorized("Already created a form");
				}
				
				feedbackFormByCoordinatorDao.save(new FeedbackFormCreatedByCoordinator(userOptional.get().getUserId(), 60));
				return "Form created";
			}
		}
	}

	@Override
	public FeedBackForm editFeedbackForm(String key, String message, int formId, String email) {
		Optional<LoginSession> optional = loginSessionDao.findById(key);
		if(!optional.isPresent()) {
			throw new UserUnauthorized("Login first!! unautorised");
		}
		else {
			if(optional.get().getUserType().equals(UserType.RESPONDENT)) {
				throw new UserUnauthorized("You are not authorised");
			}
			
			Optional<FeedBackForm> optional2 = formDao.getByEmail(email);
			if (!optional2.isPresent()) {
				throw new UserUnauthorized("email not found");
			}
			optional2.get().setFeedback(message);
			optional2.get().setTime(LocalDateTime.now());
			
			formDao.save(optional2.get());
			
			return optional2.get();
		}
	}

	@Override
	public List<FeedBackForm> reviewFeedbackForm(String key) {
		Optional<LoginSession> optional = loginSessionDao.findById(key);
		if(!optional.isPresent()) {
			throw new UserUnauthorized("Login first!! unautorised");
		}
		else {
			
			if(optional.get().getUserType().equals(UserType.RESPONDENT)) {
				throw new UserUnauthorized("You are not authorised");
			}
			
			List<FeedBackForm> list = formDao.findAll();
			return list;
		}
	}

	@Override
	public FeedBackForm fillFeedbackForm(String key, String message, int formId) {
		Optional<LoginSession> optional = loginSessionDao.findById(key);
		if(!optional.isPresent()) {
			throw new UserUnauthorized("Login first!! unautorised");
		}
		else {
			if(optional.get().getUserType().equals(UserType.COORDINATOR)) {
				throw new UserUnauthorized("You are a coordinator");
			}
			else {
				
				Optional<FeedBackForm> optional2 = formDao.getByEmail(optional.get().getEmail());
				if(optional2.isPresent()) {
					throw new UserUnauthorized("Already filled the form");
				}
				
				Optional<User> optional3 = userDao.findByEmail(optional.get().getEmail());
				if(optional3.get().getAge() > 18) {
					FeedBackForm feedBackForm = new FeedBackForm(optional.get().getEmail(), message, LocalDateTime.now(), feedbackFormByCoordinatorDao.findByFormId(formId).getUserId());
					formDao.save(feedBackForm);
					
					return feedBackForm;
				}
				else {
					throw new UserUnauthorized("Your age is under 18");
				}
			}
		}
	}

}
