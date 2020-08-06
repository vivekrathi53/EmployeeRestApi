package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.entities.Attendance;
import com.vivek.spring.restAPI.repositories.AttendanceRepository;
import com.vivek.spring.restAPI.repositories.SessionLogRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class AttendanceServiceImpl  implements AttendanceService{

    private AttendanceRepository attendanceRepository;

    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    @Override
    public boolean markAttendance(String username) {
        Attendance new_presence = new Attendance(username,new Timestamp(System.currentTimeMillis()));
        attendanceRepository.save(new_presence);
        return true;
    }

    @Override
    public List<Attendance> Attendance(String username,Timestamp startTime, Timestamp endTime) {
        return attendanceRepository.findAllBy(username,startTime,endTime);
    }
}
