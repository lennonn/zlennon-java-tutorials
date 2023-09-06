package com.zlennon.order.event.listener;

import com.alibaba.fastjson2.JSONObject;
import com.zlennon.domain.DistributedTransaction;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlennon.order.service.EventBus;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DistributedTransactionEventListener {

    @Autowired
    private EventBus eventBus;

    @RabbitListener(messageConverter ="", bindings = {
            @QueueBinding(value = @Queue("txn-events-order"),
                    exchange = @Exchange(type = ExchangeTypes.TOPIC, name = "txn-events"),
                    key = "txn-events"
            )
    })
    public void onMessage(String transaction) {
        log.info("Transaction message received: {}", transaction);
        eventBus.sendTransaction(JSONObject.parseObject(transaction,DistributedTransaction.class));
    }

}
