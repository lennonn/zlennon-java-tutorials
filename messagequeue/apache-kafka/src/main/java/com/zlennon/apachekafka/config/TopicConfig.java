package com.zlennon.apachekafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

    @Value(value = "${multi.type.topic.name}")
    private String multiTypeTopicName;

    @Bean
    NewTopic inputTopic(){
        return TopicBuilder.name("input-topic").partitions(1).replicas(1).build();
    }

    @Bean
    NewTopic outTopic(){
        return TopicBuilder.name("output-topic").partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic multiTypeTopic() {
        return new NewTopic(multiTypeTopicName, 1, (short) 1);
    }
}
