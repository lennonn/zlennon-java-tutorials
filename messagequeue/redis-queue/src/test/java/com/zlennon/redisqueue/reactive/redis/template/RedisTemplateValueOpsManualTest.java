package com.zlennon.redisqueue.reactive.redis.template;


import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import com.zlennon.redisqueue.RedisQueueApplication;
import com.zlennon.redisqueue.model.OrderEvent;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import redis.embedded.RedisServerBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RedisQueueApplication.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class RedisTemplateValueOpsManualTest {
    
    private static redis.embedded.RedisServer redisServer;

    @Autowired
    private ReactiveRedisTemplate<String, OrderEvent> redisTemplate;

    private ReactiveValueOperations<String, OrderEvent> reactiveValueOps;
    
    @BeforeClass
    public static void startRedisServer() throws IOException {
        redisServer = new RedisServerBuilder().port(6379).setting("maxmemory 256M").build();
        redisServer.start();
    }
    
    @AfterClass
    public static void stopRedisServer() throws IOException {
        redisServer.stop();
    }

    @Before
    public void setup() {
        reactiveValueOps = redisTemplate.opsForValue();
    }

    @Test
    public void givenOrderEvent_whenSet_thenSet() {

        Mono<Boolean> result = reactiveValueOps.set("123", new OrderEvent("123", OrderEvent.EventType.CREATE, LocalDateTime.now(),"create"));

        StepVerifier.create(result)
            .expectNext(true)
            .verifyComplete();
    }

    @Test
    public void givenOrderEventId_whenGet_thenReturnsOrderEvent() {

        Mono<OrderEvent> fetchedOrderEvent = reactiveValueOps.get("123");

        StepVerifier.create(fetchedOrderEvent)
            .expectNext(new OrderEvent("123", OrderEvent.EventType.CREATE, LocalDateTime.now(),"create"))
            .verifyComplete();
    }

    @Test
    public void givenOrderEvent_whenSetWithExpiry_thenSetsWithExpiryTime() throws InterruptedException {

        Mono<Boolean> result = reactiveValueOps.set("129",
                new OrderEvent("123", OrderEvent.EventType.CREATE, LocalDateTime.now(),"create"), Duration.ofSeconds(1));

        Mono<OrderEvent> fetchedOrderEvent = reactiveValueOps.get("129");

        StepVerifier.create(result)
            .expectNext(true)
            .verifyComplete();

        Thread.sleep(2000L);

        StepVerifier.create(fetchedOrderEvent)
            .expectNextCount(0L)
            .verifyComplete();
    }

}
