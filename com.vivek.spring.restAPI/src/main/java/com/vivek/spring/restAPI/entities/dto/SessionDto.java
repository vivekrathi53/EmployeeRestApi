package com.vivek.spring.restAPI.entities.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SessionDto {
    String sessionId;
    Timestamp endTime;
    public SessionDto(String sessionId,Timestamp endTime) {
        this.sessionId = sessionId;
        this.endTime = endTime;
    }
}
