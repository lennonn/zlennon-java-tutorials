package com.zlennon.springintegration.dsl.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.context.IntegrationFlowContext;
import org.springframework.integration.kafka.dsl.Kafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaDslService {


    @Autowired
    private KafkaAppProperties properties;

    @Autowired
    private IntegrationFlowContext flowContext;

    @Autowired
    private KafkaProperties kafkaProperties;

    @Autowired
    private KafkaGateway kafkaGateway;

    public void runDemo() {
        System.out.println("Sending 10 messages...");
        for (int i = 0; i < 10; i++) {
            String message = "foo" + i;
            System.out.println("Send to Kafka before adapter: " + message);
            kafkaGateway.sendToKafka(message, this.properties.getTopic());
        }

        for (int i = 0; i < 10; i++) {
            Message<?> received = kafkaGateway.receiveFromKafka();
            System.out.println("received fromKafka channel:"+received);
        }
        System.out.println("Adding an adapter for a second topic and sending 10 messages...");
        addAnotherListenerForTopics(this.properties.getNewTopic());
        for (int i = 0; i < 10; i++) {
            String message = "bar" + i;
            System.out.println("Send to Kafka: " + message);
            kafkaGateway.sendToKafka(message, this.properties.getNewTopic());
        }
        for (int i = 0; i < 10; i++) {
            Message<?> received = kafkaGateway.receiveFromKafka();
            System.out.println("after adapter received:" +received);
        }
        //context.close();
    }


    public void addAnotherListenerForTopics(String... topics) {
        Map<String, Object> consumerProperties = kafkaProperties.buildConsumerProperties();
        // change the group id so we don't revoke the other partitions.
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG,
                consumerProperties.get(ConsumerConfig.GROUP_ID_CONFIG) + "x");
        IntegrationFlow flow =
                IntegrationFlow
                        .from(Kafka.messageDrivenChannelAdapter(
                                new DefaultKafkaConsumerFactory<String, String>(consumerProperties), topics))
                        .channel("fromKafka")
                        .get();
        this.flowContext.registration(flow).register();
    }
}
