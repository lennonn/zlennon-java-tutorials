package com.zlennon.chatgptmodelservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages="com.zlennon.*")
@EnableDiscoveryClient
public class ChatgptModelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatgptModelServiceApplication.class, args);
	}

}
