package com.zlennon.loadbalancer.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    @Value("${server.instance.id}")
    String instanceId;

    @PostMapping("/hello")
    public String hello(HttpServletRequest request)
    {
        return String.format("Hello from instance %s", instanceId);
    }
}
