package com.zlennon.redisqueue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
//@Entity
//@Table(name = "order_event")
@RedisHash("OrderEvent")
public class OrderEvent {
    @Id
    String orderId;

    //@Column(name = "type")
    private EventType type;

    public OrderEvent() {

    }

    public enum EventType {
        CREATE, UPDATE
    }
    //@Column(name = "occur_time")
    LocalDateTime occurTime;

    //@Column(name = "message")
    String message;
}
