package com.vivek.spring.restAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vivek.spring.restAPI.Entities.Session;
import com.vivek.spring.restAPI.Entities.User;

public interface SessionRepository extends JpaRepository<Session, String>
{
	public Session findAllBySessionId(String sessionId);
	public void deleteAllByUsername(String username);
}
