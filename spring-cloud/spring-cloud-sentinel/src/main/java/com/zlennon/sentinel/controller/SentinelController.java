package com.zlennon.sentinel.controller;

import com.zlennon.sentinel.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentinelController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/hello")
    public String getGreeting() {
        return greetingService.getGreeting();
    }
}
