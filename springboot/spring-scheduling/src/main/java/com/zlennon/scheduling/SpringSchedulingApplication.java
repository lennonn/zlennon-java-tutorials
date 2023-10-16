package com.zlennon.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.zlennon.**.**")
public class SpringSchedulingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSchedulingApplication.class, args);
	}

}
