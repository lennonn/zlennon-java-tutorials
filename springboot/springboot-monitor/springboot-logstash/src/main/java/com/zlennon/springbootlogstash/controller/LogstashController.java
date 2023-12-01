package com.zlennon.springbootlogstash.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logstash")
@Slf4j
public class LogstashController {

    @RequestMapping("/hello")
    public ResponseEntity helloLogstash(){
      log.info("log from springboot-logstash");
      log.error("test error msg on kibanahe:{}",Thread.currentThread().getName());
      return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
