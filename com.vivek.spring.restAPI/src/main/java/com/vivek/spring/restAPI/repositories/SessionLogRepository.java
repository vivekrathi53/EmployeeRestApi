package com.vivek.spring.restAPI.repositories;

import com.vivek.spring.restAPI.entities.SessionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionLogRepository extends JpaRepository<SessionLog, String>
{

}
