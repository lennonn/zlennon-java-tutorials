package com.zlennon.mockito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.zlennon.mockito.config")
public class MokitoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MokitoApplication.class, args);
    }

}
