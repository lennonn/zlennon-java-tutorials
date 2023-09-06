package com.zlennon.chatgptapiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.zlennon.**")
@EnableDiscoveryClient
public class ChatgptApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatgptApiServiceApplication.class, args);
	}

}
