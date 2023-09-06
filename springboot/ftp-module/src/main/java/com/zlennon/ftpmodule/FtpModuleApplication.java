package com.zlennon.ftpmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.zlennon")
@EnableJpaRepositories
@SpringBootApplication
public class FtpModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FtpModuleApplication.class, args);
	}

}
