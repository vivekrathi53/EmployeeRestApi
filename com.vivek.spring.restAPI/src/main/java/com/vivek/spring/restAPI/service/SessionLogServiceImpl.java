package com.vivek.spring.restAPI.service;

import com.vivek.spring.restAPI.Entities.Session;
import com.vivek.spring.restAPI.Entities.SessionLog;
import com.vivek.spring.restAPI.Repositories.SessionLogRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SessionLogServiceImpl implements SessionLogService {


    private SessionLogRepository sessionLogRepository;

    public SessionLogServiceImpl(SessionLogRepository sessionLogRepository) {
        this.sessionLogRepository = sessionLogRepository;
    }

    public void saveSession(Session session)
    {
        if(session==null)
            return;
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        if(endTime.getTime()>((session.getStartTime()).getTime()+30*60*1000))
            endTime = new Timestamp(((session.getStartTime()).getTime()+30*60*1000));
        SessionLog sessionLog = new SessionLog(session.getSessionId(),session.getStartTime(),new Timestamp(System.currentTimeMillis()),session.getUsername());
        sessionLogRepository.save(sessionLog);
        return ;
    }
}
