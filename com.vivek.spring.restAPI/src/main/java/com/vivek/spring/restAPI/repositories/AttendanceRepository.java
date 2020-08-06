package com.vivek.spring.restAPI.repositories;


import com.vivek.spring.restAPI.entities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, String> {
    @Query(value = "SELECT * FROM attendance a where a.in_time >= :startTime and a.in_time <= :endTime and username = :username", nativeQuery =true)
    public List<Attendance> findAllBy(@Param("username")String username,@Param("startTime")Timestamp startTime, @Param("endTime")Timestamp endTime);
}
