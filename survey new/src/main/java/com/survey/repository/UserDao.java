package com.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.survey.modal.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {	

	public Optional<User> findByEmail(String email);
}
