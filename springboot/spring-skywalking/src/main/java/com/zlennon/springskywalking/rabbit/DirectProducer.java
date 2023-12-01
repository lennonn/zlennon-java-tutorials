package com.zlennon.springskywalking.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DirectProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void send(){
        rabbitTemplate.convertAndSend(Constant.DIRECT_EXCHANGE_NAME,
                Constant.DIRECT_EXCHANGE_ROUT_KEY, "direct msg");
    }
}
