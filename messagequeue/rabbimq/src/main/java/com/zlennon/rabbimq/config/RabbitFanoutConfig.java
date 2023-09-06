package com.zlennon.rabbimq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.zlennon.rabbimq.Constant.*;


@Configuration
public class RabbitFanoutConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Bean
    public Declarables topicBindings() {
        Queue topicQueue1 = new Queue(TOPIC_QUEUE_1_NAME, NON_DURABLE);
        Queue topicQueue2 = new Queue(TOPIC_QUEUE_2_NAME, NON_DURABLE);
        rabbitAdmin.declareQueue(topicQueue1);
        rabbitAdmin.declareQueue(topicQueue2);

        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME, NON_DURABLE, true);
        rabbitAdmin.declareExchange(topicExchange);

        return new Declarables( BindingBuilder
                .bind(topicQueue1)
                .to(topicExchange)
                .with(BINDING_PATTERN_IMPORTANT), BindingBuilder
                .bind(topicQueue2)
                .to(topicExchange)
                .with(BINDING_PATTERN_ERROR));
    }

    @Bean
    public Declarables fanoutBindings() {
        Queue fanoutQueue1 = new Queue(FANOUT_QUEUE_1_NAME, NON_DURABLE);
        Queue fanoutQueue2 = new Queue(FANOUT_QUEUE_2_NAME, NON_DURABLE);
        rabbitAdmin.declareQueue(fanoutQueue1);
        rabbitAdmin.declareQueue(fanoutQueue2);

        FanoutExchange fanoutExchange = new FanoutExchange(FANOUT_EXCHANGE_NAME, NON_DURABLE, true);
        rabbitAdmin.declareExchange(fanoutExchange);
        return new Declarables( BindingBuilder
                .bind(fanoutQueue1)
                .to(fanoutExchange), BindingBuilder
                .bind(fanoutQueue2)
                .to(fanoutExchange));
    }
}
