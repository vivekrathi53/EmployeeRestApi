package com.vivek.spring.restAPI.Entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="sessionlog")
@IdClass(CompositeKey.class)
public class SessionLog
{
    @Id
    @Column(name="sessionId")
    private String sessionId;//need to implement composite key here
    @Id
    @Column(name="startTime")
    private Timestamp startTime;
    @Id
    @Column(name="endTime")
    private Timestamp endTime;
    @Column(name="username")
    private String username;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getUsername() {
        return username;
    }

    public SessionLog(String sessionId, Timestamp startTime, Timestamp endTime, String username) {
        this.sessionId = sessionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SessionLog()
    {

    }

}
