package com.vivek.spring.restAPI.repositories;

import com.vivek.spring.restAPI.entities.Attendance;
import com.vivek.spring.restAPI.entities.SessionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionLogRepository extends JpaRepository<SessionLog, String>
{

}
