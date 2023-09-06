package com.zlennon.rabbimq;

import com.zlennon.rabbimq.direct.DirectProducer;
import com.zlennon.rabbimq.fanout.FanoutProducter;
import com.zlennon.rabbimq.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbimqApplication implements CommandLineRunner {

    @Autowired
    FanoutProducter fanoutProducter;

    @Autowired
    DirectProducer directProducer;

    @Autowired
    TopicProducer topicProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbimqApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        fanoutProducter.send();
        fanoutProducter.sendMsg("fanout new pattern");
        directProducer.send();*/
        topicProducer.sendMessage("topic msg");
        topicProducer.sendMessage2("ReturnsCallback");
    }
}
