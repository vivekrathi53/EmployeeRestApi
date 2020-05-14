package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.entities.Session;

public interface SessionService {
    public Session getSession(String sessionId);
    public boolean checkSessionId(String sessionId);
    public Session getNewSession(String username);
    public boolean logoutSession(String sessionId);
    public Session getSessionByUsername(String username);
}
