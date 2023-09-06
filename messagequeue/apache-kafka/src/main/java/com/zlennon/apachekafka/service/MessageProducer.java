package com.zlennon.apachekafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public  class MessageProducer {
    private final KafkaTemplate<Integer, String> template;

    public MessageProducer(KafkaTemplate<Integer, String> template) {
        this.template = template;
    }

    public void send(String toSend, int key) {
        this.template. send("topic1", key, toSend);
    }
}
