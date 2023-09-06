package com.zlennon.apachekafka.controller;

import com.zlennon.apachekafka.service.MessageService;
import com.zlennon.apachekafka.service.stream.KafkaStreamProducer;
import lombok.AllArgsConstructor;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/message")
public class MessageController {

    @Qualifier
    MessageService messageService;

    @RequestMapping("/hello")
    public void hello() {
        messageService.execute();
    }
}
