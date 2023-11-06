package com.example.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
@Slf4j
public class HelloController {
    @Value("${server.port}")
    String port;

    @Autowired
    WebClient.Builder webClientBuilder;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request)
    {
        return "response from instance-server:"+port;
    }
}
