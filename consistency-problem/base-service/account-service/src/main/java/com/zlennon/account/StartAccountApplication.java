package com.zlennon.account;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import io.seata.spring.boot.autoconfigure.SeataAutoConfiguration;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDiscoveryClient
@SpringBootApplication()
//@EnableJpaRepositories
//@EnableAsync
@EnableRabbit
public class StartAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartAccountApplication.class, args);
    }
}
