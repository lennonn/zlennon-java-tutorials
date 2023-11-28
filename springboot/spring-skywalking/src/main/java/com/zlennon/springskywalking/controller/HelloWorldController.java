package com.zlennon.springskywalking.controller;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/skywalking")
public class HelloWorldController {

    @RequestMapping("/hello")
    public ResponseEntity helloWorld() throws InterruptedException {
        Thread.sleep(1000);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
