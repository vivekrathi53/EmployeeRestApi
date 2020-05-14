package com.vivek.spring.restAPI.Repositories;

import com.vivek.spring.restAPI.Entities.SessionLog;
import com.vivek.spring.restAPI.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionLogRepository extends JpaRepository<SessionLog, String>
{

}
