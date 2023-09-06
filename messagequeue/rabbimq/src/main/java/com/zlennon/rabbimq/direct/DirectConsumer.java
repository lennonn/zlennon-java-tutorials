package com.zlennon.rabbimq.direct;

import com.zlennon.rabbimq.Constant;
import com.zlennon.rabbimq.config.RabbitDirectConfig;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DirectConsumer {
    Logger logger = LoggerFactory.getLogger(DirectConsumer.class);
    @RabbitHandler
    @RabbitListener(queues = {Constant.DIRECT_QUEUE_NAME})
    public void receiveFromDirect(String message) {
        logger.info("Received queueName = {}, message = {}",Constant.DIRECT_QUEUE_NAME, message);
        System.out.println(message);
    }
}
