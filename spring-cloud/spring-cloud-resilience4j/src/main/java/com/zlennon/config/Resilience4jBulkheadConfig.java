package com.zlennon.config;


import io.github.resilience4j.bulkhead.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jBulkheadConfig {



    @Bean
    public Bulkhead bulkhead (){
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(1))
                .build();
        BulkheadRegistry registry = BulkheadRegistry.of(config);
        return registry.bulkhead("myBulkhead");
    }

    @Bean
    public ThreadPoolBulkhead threadBulkhead (){
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(10)
                .coreThreadPoolSize(2)
                .queueCapacity(5)
                .build();

        return ThreadPoolBulkhead.of("threadBulkhead", config);
    }

}
