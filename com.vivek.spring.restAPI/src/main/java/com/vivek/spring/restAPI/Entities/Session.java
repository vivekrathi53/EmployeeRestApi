package com.vivek.spring.restAPI.Entities;

import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name="sessions")
public class Session {
	
	@Id
	private String sessionId;
	
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	private Timestamp startTime;
	@Column(unique=true)
	private String username;
	public Session()
	{
		
	}
	public Session(String username)
	{
		startTime = new Timestamp(System.currentTimeMillis());
		this.username = username;
	}
}
