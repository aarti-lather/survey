package com.survey.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.survey.dto.LoginSession;

public interface LoginSessionDao extends JpaRepository<LoginSession, String>{

}
