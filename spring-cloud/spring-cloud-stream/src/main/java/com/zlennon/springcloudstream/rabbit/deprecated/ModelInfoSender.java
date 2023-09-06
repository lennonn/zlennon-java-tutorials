package com.zlennon.springcloudstream.rabbit.deprecated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;

//@EnableBinding(value ={SinkSender.class})
public class ModelInfoSender {
    private static Logger logger = LoggerFactory.getLogger(ModelInfoSender.class);

   // @Autowired
    private SinkSender sinkSender;

    public void send() {
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
        logger.info("send msg success");
    }
}
