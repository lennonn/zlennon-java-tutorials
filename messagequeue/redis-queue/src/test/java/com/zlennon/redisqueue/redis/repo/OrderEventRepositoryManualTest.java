package com.zlennon.redisqueue.redis.repo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.zlennon.redisqueue.config.RedisConfig;
import com.zlennon.redisqueue.model.OrderEvent;
import com.zlennon.redisqueue.repo.OrderEventRepository;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import redis.embedded.RedisServerBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@Profile("default")
@ContextConfiguration(classes = RedisConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class OrderEventRepositoryManualTest {

    @Autowired
    private OrderEventRepository orderEventRepository;
    
    private static redis.embedded.RedisServer redisServer;
    
    @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 128M").build();
        redisServer.start();
    }
    
    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }

    @Test
    public void whenSavingOrderEvent_thenAvailableOnRetrieval() throws Exception {
        final OrderEvent event = new OrderEvent("11111", OrderEvent.EventType.CREATE, LocalDateTime.now(), "order created");
        orderEventRepository.save(event);
        final OrderEvent retrievedOrderEvent = orderEventRepository.findById(event.getOrderId()).get();
        assertEquals(event.getOrderId(), retrievedOrderEvent.getOrderId());
    }

    @Test
    public void whenUpdatingOrderEvent_thenAvailableOnRetrieval() throws Exception {
        final OrderEvent order = new OrderEvent("11111", OrderEvent.EventType.CREATE, LocalDateTime.now(), "order created");
        orderEventRepository.save(order);
        order.setMessage("Richard Watson");
        orderEventRepository.save(order);
        final OrderEvent retrievedOrderEvent = orderEventRepository.findById(order.getOrderId()).get();
        assertEquals(order.getMessage(), retrievedOrderEvent.getMessage());
    }

    @Test
    public void whenSavingOrderEvents_thenAllShouldAvailableOnRetrieval() throws Exception {
        final OrderEvent engOrderEvent = new OrderEvent("11111", OrderEvent.EventType.CREATE, LocalDateTime.now(), "order created");

        final OrderEvent medOrderEvent = new OrderEvent("2222", OrderEvent.EventType.CREATE, LocalDateTime.now(), "order created");

        orderEventRepository.save(engOrderEvent);
        orderEventRepository.save(medOrderEvent);
        List<OrderEvent> events = new ArrayList<>();
        orderEventRepository.findAll().forEach(events::add);
        assertEquals(events.size(), 2);
    }

    @Test
    public void whenDeletingOrderEvent_thenNotAvailableOnRetrieval() throws Exception {
        final OrderEvent orderEvent = new OrderEvent("2222", OrderEvent.EventType.CREATE, LocalDateTime.now(), "order created");

        orderEventRepository.save(orderEvent);
        orderEventRepository.deleteById(orderEvent.getOrderId());
        final OrderEvent retrievedOrderEvent = orderEventRepository.findById(orderEvent.getOrderId()).orElse(null);
        assertNull(retrievedOrderEvent);
    }
}