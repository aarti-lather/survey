package com.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.dto.FeedbackFormCreatedByCoordinator;

public interface FeedbackFormByCoordinatorDao extends JpaRepository<FeedbackFormCreatedByCoordinator, Integer>{

	public FeedbackFormCreatedByCoordinator findByFormId(Integer formId);
}

