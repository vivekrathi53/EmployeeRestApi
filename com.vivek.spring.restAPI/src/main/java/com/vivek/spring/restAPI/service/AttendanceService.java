package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.entities.Attendance;

import java.sql.Timestamp;
import java.util.List;

public interface AttendanceService {
    public boolean markAttendance(String username);
    public List<Attendance> Attendance(String username,Timestamp startTime,Timestamp endTime);
}
