package com.vivek.spring.restAPI.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vivek.spring.restAPI.entities.Session;

public interface SessionRepository extends JpaRepository<Session, String>
{
	public Session findAllBySessionId(String sessionId);
	public Session findAllByUsername(String username);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM sessions s where s.username = :username", nativeQuery =true)
	public void deleteByUsername(@Param("username")String username);
}
