package com.zlennon.resilience4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circuitbreaker")
public class DemoController {

    @Autowired
    Resilience4jService service;


    @RequestMapping("/getAllModel")
    public ResponseEntity getAllModel(){
        return service.getAllModel();
    }

    @RequestMapping("/getChatGPTById/{modelId}")
    public ResponseEntity getChatGPTById(@PathVariable String modelId){
        return service.getChatGPTById(modelId);
    }

    @RequestMapping("/retry")
    public ResponseEntity retry(){
        return service.retry();
    }

    @RequestMapping("/bulkhead")
    public ResponseEntity bulkhead(){
        return service.bulkhead();
    }
}
