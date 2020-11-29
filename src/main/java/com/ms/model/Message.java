package com.ms.model;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class Message {

    private long id;

    private int msisdn;

    private Action action;

    private Timestamp timestamp;

}