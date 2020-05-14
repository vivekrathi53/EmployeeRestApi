package com.vivek.spring.restAPI.Entities;

import java.sql.Timestamp;

import javax.annotation.Generated;
import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name="sessions")
public class Session {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	@Column(name="sessionId")
	private String sessionId;
	@Column(name="startTime")
	private Timestamp startTime;
	@Column(unique=true)
	private String username;
	@Column(name="loginStatus")
	private LoginStatus loginStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}

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

	public Session()
	{
		
	}
	public Session(String username)
	{
		startTime = new Timestamp(System.currentTimeMillis());
		this.username = username;
	}
}
