package com.zlennon.apachekafka.service.stream;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class KafkaStreamProducer {

    private final KafkaTemplate<String, String> kafkaStringTemplate;

    public void sendMessage(String message) {
        kafkaStringTemplate.send("input-topic",message).exceptionally((result)->{
                log.info("Message sent to topic: {}", message);
               // log.error("Failed to send message",ex);
                return null;
        });
    }
}
