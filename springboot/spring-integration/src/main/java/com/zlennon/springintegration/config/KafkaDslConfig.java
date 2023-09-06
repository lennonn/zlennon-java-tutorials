package com.zlennon.springintegration.config;

import com.zlennon.springintegration.dsl.kafka.KafkaAppProperties;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Configuration
public class KafkaDslConfig {

    @Autowired
    KafkaAppProperties properties;

    @Bean
    public IntegrationFlow toKafka(KafkaTemplate<?, ?> kafkaTemplate) {
        return f -> f
                .handle(Kafka.outboundChannelAdapter(kafkaTemplate)
                        .messageKey(this.properties.getMessageKey()));
    }

    @Bean
    public IntegrationFlow fromKafkaFlow(ConsumerFactory<?, ?> consumerFactory) {
        return IntegrationFlow
                .from(Kafka.messageDrivenChannelAdapter(consumerFactory, this.properties.getTopic()))
                .channel(c -> c.queue("fromKafka"))
                .get();
    }

    /*
     * Boot's autoconfigured KafkaAdmin will provision the topics.
     */

    @Bean
    public NewTopic topic(KafkaAppProperties properties) {
        return new NewTopic(properties.getTopic(), 1, (short) 1);
    }

    @Bean
    public NewTopic newTopic(KafkaAppProperties properties) {
        return new NewTopic(properties.getNewTopic(), 1, (short) 1);
    }
}
