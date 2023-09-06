package com.zlennon.shardingsphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zlennon.*")
public class ShardingsphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingsphereApplication.class, args);
	}

}
