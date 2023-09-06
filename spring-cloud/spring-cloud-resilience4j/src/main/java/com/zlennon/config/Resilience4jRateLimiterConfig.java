package com.zlennon.config;


import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jRateLimiterConfig {


    /*

    timeoutDuration	5[s]	    线程等待令牌的时间
    limitRefreshPeriod	500[ns]	令牌刷新周期，每次刷新，剩余令牌数都恢复到默认值
    limitForPeriod	50	        每个周期的初始令牌数
     */
    @Bean
    public RateLimiterConfig rateLimiterConfig(){
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .timeoutDuration(Duration.ofSeconds(1))
                .build();
        return config;
    }

    @Bean
    public RateLimiterRegistry rateLimiterRegistry(RateLimiterConfig rateLimiterConfig){
       return RateLimiterRegistry.of(rateLimiterConfig);
    }


    @Bean
    public RateLimiter rateLimiter(RateLimiterRegistry rateLimiterRegistry){
        return rateLimiterRegistry.rateLimiter("modelRateLimter");
    }

}
