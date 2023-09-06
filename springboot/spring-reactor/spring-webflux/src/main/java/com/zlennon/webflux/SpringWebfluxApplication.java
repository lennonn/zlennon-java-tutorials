package com.zlennon.webflux;

import com.zlennon.webflux.controller.ModelClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebfluxApplication.class, args);
        ModelClient modelClient = new ModelClient();
        modelClient.consume();
    }

}
