package com.zlennon.rabbimq.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("myTopicExchange", "myTopicRoutingKey.test", message);
    }

    public void sendMessage2(String message) {
        rabbitTemplate.convertAndSend("myTopicExchange", "ReturnsCallback", message);
    }
}
