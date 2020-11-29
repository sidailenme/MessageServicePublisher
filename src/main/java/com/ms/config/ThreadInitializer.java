package com.ms.config;

import com.ms.service.impl.MessageSenderImpl;
import lombok.AllArgsConstructor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
public class ThreadInitializer {

    private final TaskExecutor taskExecutor;
    private final MessageSenderImpl messageSender;

    @PostConstruct
    public void init() {
        taskExecutor.execute(messageSender);
        taskExecutor.execute(messageSender);
        taskExecutor.execute(messageSender);
        taskExecutor.execute(messageSender);
        taskExecutor.execute(messageSender);
    }
}
