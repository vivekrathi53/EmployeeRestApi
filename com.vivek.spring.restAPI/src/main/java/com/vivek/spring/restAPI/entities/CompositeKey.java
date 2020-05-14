package com.vivek.spring.restAPI.entities;

import java.io.Serializable;
import java.sql.Timestamp;

public class CompositeKey implements Serializable {

    private String sessionId;

    private Timestamp startTime;

    private Timestamp endTime;
}
