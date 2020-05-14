package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.Entities.LoginStatus;
import com.vivek.spring.restAPI.Entities.Session;
import com.vivek.spring.restAPI.Repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;
    @Override
    public boolean checkSessionId(String sessionId)
    {
        Session session = sessionRepository.findAllBySessionId(sessionId);
        if(session==null)
            return false;
        else
            return true;
    }
    @Override
    public Session getSession(String sessionId)
    {
        return sessionRepository.findAllBySessionId(sessionId);
    }
    @Override
    public Session getNewSession(String username)
    {
        Session session = new Session(username);
        Random randomGenerator = new Random();


        while(true)
        {
            String generatedString=Integer.toString(1000000+randomGenerator.nextInt()%1000000);
            if(!checkSessionId(generatedString))
            {
                session.setSessionId(generatedString);
                session.setLoginStatus(LoginStatus.ACTIVE);
                sessionRepository.save(session);
                break;
            }
        }

        return session;
    }

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public boolean logoutSession(String sessionId)
    {
        if(!checkSessionId(sessionId))
            return false;
        Session session = getSession(sessionId);
        sessionRepository.deleteByUsername(session.getUsername());
        return true;
    }

    @Override
    public Session getSessionByUsername(String username)
    {
        return sessionRepository.findAllByUsername(username);
    }
}
