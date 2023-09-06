package com.zlennon.config;


import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Configuration
public class Resilience4jRetryConfig {


   @Bean
    public RetryConfig retryConfig(){
       return RetryConfig.custom()
                .maxAttempts(2)
                .waitDuration(Duration.ofMillis(1000))
                //.retryOnResult((HttpServletResponse) response -> response() == 500)
                .retryExceptions(IOException.class, TimeoutException.class)
                .failAfterMaxAttempts(true)
                .build();
    }

    @Bean
    public Retry  retry ( RetryConfig retryConfig){
        RetryConfig config = RetryConfig.custom().maxAttempts(2).build();
        RetryRegistry registry = RetryRegistry.of(config);
        return  registry.retry("myRetry");
    }


}
