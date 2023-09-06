package com.zlennon.websocketclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebsocketClientApplication implements CommandLineRunner {

    @Autowired
    SendMsgService sendMsgService;

    public static void main(String[] args) {
        SpringApplication.run(WebsocketClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String send = sendMsgService.send();
        System.out.println("WebsocketClientApplication msg "+send);
    }
}
