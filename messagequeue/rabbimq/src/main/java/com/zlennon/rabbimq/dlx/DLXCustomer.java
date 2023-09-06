package com.zlennon.rabbimq.dlx;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zlennon.rabbimq.Constant.QUEUE_MESSAGES_DLQ;

@Component
@Slf4j
public class DLXCustomer {

    @RabbitListener(queues = {QUEUE_MESSAGES_DLQ })
    public void receiveMsgFromDLX(String message) {
        log.info("DLXCustomer message: {}" , message);
    }
}
