package com.zlennon.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication(scanBasePackages="com.zlennon")
@EnableDiscoveryClient
@EnableWebFlux
public class SpringCloudGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudGateWayApplication.class, args);
    }

}
