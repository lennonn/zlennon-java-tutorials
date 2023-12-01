package com.zlennon.springskywalking.rabbit;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DirectConsumer {
    Logger logger = LoggerFactory.getLogger(DirectConsumer.class);

    @Autowired
    RedisTemplate redisTemplate;


    @RabbitHandler
    @RabbitListener(queues = {Constant.DIRECT_QUEUE_NAME})
    public void receiveFromDirect(String message) throws InterruptedException {
        Thread.sleep(100);
        redisTemplate.opsForHash().put("skywalking",Thread.currentThread().getName(),message);
        logger.info("Received queueName = {}, message = {}",Constant.DIRECT_QUEUE_NAME, message);
    }
}
