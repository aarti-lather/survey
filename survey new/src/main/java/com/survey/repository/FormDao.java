package com.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.modal.FeedBackForm;

@Repository
public interface FormDao extends JpaRepository<FeedBackForm, Integer>{

	public Optional<FeedBackForm> getByEmail(String email);
	public Optional<FeedBackForm> getByUserId(Integer userId);
}
