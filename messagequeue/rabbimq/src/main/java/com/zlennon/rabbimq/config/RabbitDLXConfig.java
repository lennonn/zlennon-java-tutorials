package com.zlennon.rabbimq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.zlennon.rabbimq.Constant.*;

@Configuration
public class RabbitDLXConfig {




    @Bean
    TopicExchange deadLetterExchange() {
        return new TopicExchange(DLX_EXCHANGE_MESSAGES);
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(QUEUE_MESSAGES_DLQ).build();
    }

    @Bean
    Binding deadLetterBinding() {
       return BindingBuilder
                .bind(deadLetterQueue())
                .to(deadLetterExchange())
                .with(DLX_ROUTEING_KEY);
    }


}
