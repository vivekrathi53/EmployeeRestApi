package com.vivek.spring.restAPI.Repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vivek.spring.restAPI.Entities.Session;

public interface SessionRepository extends JpaRepository<Session, String>
{
	public Session findAllBySessionId(String sessionId);
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM sessions s where s.username = :username", nativeQuery =true)
	public void deleteByUsername(@Param("username")String username);
}
