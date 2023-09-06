package com.zlennon.rabbimq.fanout;

import com.rabbitmq.client.Channel;
import com.zlennon.rabbimq.Constant;
import com.zlennon.rabbimq.config.RabbitFanoutConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class FanoutCustomer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(),
            exchange = @Exchange(name = "myFanout", type = ExchangeTypes.FANOUT)
    ))
    public void fanout(String data, Channel channel, Message message)  throws IOException {
        log.info("fanout consume data:{}"+ data);
    }

    @RabbitListener(queues = { Constant.FANOUT_QUEUE_1_NAME })
    public void receiveMessageFromFanout1(String message) {
        log.info("FanoutCustomer1 Received fanout 1 message: {}" , message);
    }


    @RabbitListener(queues = { Constant.TOPIC_QUEUE_1_NAME })
    public void receiveMessageFromTopic1(String message) {
        log.info("FanoutCustomer1 Received topic 1 (" + Constant.BINDING_PATTERN_IMPORTANT + ") message: {}" , message);
    }

}
