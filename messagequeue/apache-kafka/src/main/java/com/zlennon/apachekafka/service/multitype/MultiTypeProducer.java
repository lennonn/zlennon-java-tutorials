package com.zlennon.apachekafka.service.multitype;

import com.zlennon.commonentity.message.Farewell;
import com.zlennon.commonentity.message.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MultiTypeProducer {

    @Autowired
    private KafkaTemplate<String, Object> multiTypeKafkaTemplate;

    @Value(value = "${multi.type.topic.name}")
    private String multiTypeTopicName;

    public void sendMessages() {
        multiTypeKafkaTemplate.send(multiTypeTopicName, new Greeting("Greetings", "World!"));
        multiTypeKafkaTemplate.send(multiTypeTopicName, new Farewell("Farewell", 25));
        multiTypeKafkaTemplate.send(multiTypeTopicName, "Simple string message");
    }
}
