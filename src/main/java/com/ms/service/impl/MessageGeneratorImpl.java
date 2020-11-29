package com.ms.service.impl;

import com.ms.model.Action;
import com.ms.model.Message;
import com.ms.service.interfaces.MessageGenerator;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.Random;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private long id;
    private final Random random = new Random();

    @Override
    public Message generate() {
        Message message = new Message();
        message.setId(++id);
        message.setMsisdn(random.nextInt(1_000_000));
        message.setAction(Action.randomAction());
        message.setTimestamp(new Timestamp(System.currentTimeMillis()));
        return message;
    }
}

