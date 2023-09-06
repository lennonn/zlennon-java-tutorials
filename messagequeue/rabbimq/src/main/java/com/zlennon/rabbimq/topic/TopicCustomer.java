package com.zlennon.rabbimq.topic;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;

import java.util.Map;

@Slf4j
public class TopicCustomer implements ChannelAwareMessageListener {

    private static final int MAX_RETRY_ATTEMPTS = 5;


    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try{
            String body = new String(message.getBody());
            log.info("onMessage:{}", body);
            //int i = 10 / 0;
            /**
             * 确认一条消息
             * channel.basicAck(deliveryTag, false); <br>
             * deliveryTag:该消息的index <br>
             * multiple：是否批量.true:将一次性ack所有小于deliveryTag的消息 <br>
             */
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch(Exception e){
            int retryCount = (int) message.getMessageProperties().getHeaders().getOrDefault("retryCount", 0);
            if (retryCount < MAX_RETRY_ATTEMPTS) {
                // Calculate the delay time using exponential backoff
                long delay = (long) Math.pow(2, retryCount) * 1000;
                // Add the retry count header
                // Send the message to the back of the queue with a delay
                Map<String, Object> headers = message.getMessageProperties().getHeaders();
                headers.put("retryCount",retryCount + 1);
                AMQP.BasicProperties basicProperties = new AMQP.BasicProperties().builder().headers(headers).build();
                channel.basicPublish(
                        message.getMessageProperties().getReceivedExchange(),
                        message.getMessageProperties().getReceivedRoutingKey(),
                        basicProperties,
                        message.getBody()
                );
               log.info("Message processing failed, retrying in " + delay + "ms");
            } else {
                // Max retry attempts reached, send manual negative acknowledgement to remove message from queue
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                log.info("Message processing failed after " + MAX_RETRY_ATTEMPTS + " attempts, message removed from queue");
            }
        }
    }
}
