package com.zlennon.apachekafka.service;

import com.zlennon.apachekafka.service.multitype.MultiTypeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class MessageService {

    @Autowired
    MessageProducer producer;
    @Autowired
    MessageListener listener;

    @Autowired
    MultiTypeProducer multiTypeProducer;

    public void execute() {
        producer.send("hello world",42);
    }
    public void multiTypeExecute() {
        multiTypeProducer.sendMessages();
    }

}
