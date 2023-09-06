package com.zlennon.rabbimq.config;

import com.zlennon.rabbimq.topic.TopicCustomer;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.zlennon.rabbimq.Constant.DLX_EXCHANGE_MESSAGES;
import static com.zlennon.rabbimq.Constant.DLX_ROUTEING_KEY;


@Configuration
public class RabbitTopicConfig {
    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("myTopicExchange",true,true);
    }

    @Bean
    public SimpleMessageListenerContainer topicListener(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueues(topicQueue());
        //container.setDeclarationRetries(5);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        container.setMessageListener(new TopicCustomer());
        return container;
    }
    @Bean
    public Queue topicQueue() {
        return QueueBuilder.durable("myTopicQueue")
                .withArgument("x-dead-letter-exchange", DLX_EXCHANGE_MESSAGES)
                .withArgument("x-dead-letter-routing-key", DLX_ROUTEING_KEY)
                .build();
    }
    @Bean
    public Binding topicBinding() {
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with("myTopicRoutingKey.#");
    }


}

