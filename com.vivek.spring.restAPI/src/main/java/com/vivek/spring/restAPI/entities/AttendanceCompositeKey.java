package com.vivek.spring.restAPI.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class AttendanceCompositeKey implements Serializable {
    private String username;
    private Timestamp inTime;
}