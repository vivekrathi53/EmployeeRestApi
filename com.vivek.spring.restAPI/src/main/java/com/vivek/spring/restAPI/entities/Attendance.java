package com.vivek.spring.restAPI.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="attendance")
@IdClass(AttendanceCompositeKey.class)
public class Attendance {
    @Id
    @Column(name="username")
    private String username;//need to implement composite key here
    @Id
    @Column(name="in_time")
    private Timestamp inTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public Attendance(String username, Timestamp inTime) {
        this.username = username;
        this.inTime = inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Attendance() {
    }
}


