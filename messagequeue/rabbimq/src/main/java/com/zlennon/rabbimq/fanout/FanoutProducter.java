package com.zlennon.rabbimq.fanout;

import com.zlennon.rabbimq.Constant;
import com.zlennon.rabbimq.config.RabbitFanoutConfig;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProducter {

    private static String ROUTING_KEY_USER_IMPORTANT_WARN = "user.important.warn";
    private static String ROUTING_KEY_USER_IMPORTANT_ERROR = "user.important.error";

    @Autowired
    MessagePostProcessor messagePostProcessor;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send() {

        rabbitTemplate.convertAndSend("myFanout", "",
                "some msg", messagePostProcessor, new
                        CorrelationData("" +System.currentTimeMillis()));
    }

    public void sendMsg(String message) {
        //rabbitTemplate.convertAndSend(RabbitFanoutConfig.FANOUT_EXCHANGE_NAME, "", "fanout " + message);
         rabbitTemplate.convertAndSend(Constant.TOPIC_EXCHANGE_NAME, ROUTING_KEY_USER_IMPORTANT_WARN, "topic important warn" + message);
        rabbitTemplate.convertAndSend(Constant.TOPIC_EXCHANGE_NAME,ROUTING_KEY_USER_IMPORTANT_ERROR, "topic important error" + message);
    }
}
