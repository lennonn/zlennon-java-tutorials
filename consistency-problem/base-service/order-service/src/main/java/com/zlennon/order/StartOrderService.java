package com.zlennon.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@EnableDiscoveryClient
@EnableFeignClients
public class StartOrderService {

    public static void main(String[] args) {
        SpringApplication.run(StartOrderService.class, args);
    }
}
