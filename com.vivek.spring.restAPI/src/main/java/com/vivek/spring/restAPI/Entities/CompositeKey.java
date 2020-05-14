package com.vivek.spring.restAPI.Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

public class CompositeKey implements Serializable {

    private String sessionId;

    private Timestamp startTime;

    private Timestamp endTime;
}
