package com.zlennon;

import com.zlennon.resilience4j.Resilience4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCloudResilience4JApplication implements CommandLineRunner {

	@Autowired
	private Resilience4jService service;


	public static void main(String[] args) {
		SpringApplication.run(SpringCloudResilience4JApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//service.retry();
		//Thread.sleep(10000);
	}
}
