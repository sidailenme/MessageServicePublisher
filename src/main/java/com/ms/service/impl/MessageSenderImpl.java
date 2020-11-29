package com.ms.service.impl;

import com.ms.model.Message;
import com.ms.service.interfaces.MessageGenerator;
import com.ms.service.interfaces.MessageSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
@Scope("prototype")
public class MessageSenderImpl implements MessageSender, Runnable {

    @Value("${spring.config.target-url}")
    private String url;

    private final MessageGenerator messageGenerator;

    public MessageSenderImpl(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void sendMessage() {
        Message message = messageGenerator.generate();
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, message, String.class);
        } catch (RestClientException e) {
            System.out.println("WARN: Сообщение не отправлено");
        }
    }

    @Override
    public void run() {
        while (true) {
            sendMessage();
            try {
                Thread.sleep(15_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}