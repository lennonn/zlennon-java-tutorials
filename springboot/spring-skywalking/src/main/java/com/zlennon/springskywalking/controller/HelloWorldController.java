package com.zlennon.springskywalking.controller;


import com.zlennon.springskywalking.rabbit.DirectProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/skywalking")
@Slf4j
public class HelloWorldController {

    @Autowired
    DirectProducer directProducer;

    @RequestMapping("/hello")
    @Trace
    @Tags({@Tag(key = "param", value = "arg[0]"),
            @Tag(key = "result", value = "returnedObj")})
    public ResponseEntity helloWorld(@RequestParam(required = false) String param) throws InterruptedException {
        Thread.sleep(2000);
        log.info("request param ==> {}",param);
        directProducer.send();
        return new ResponseEntity<>("success",HttpStatusCode.valueOf(200));
    }
}
