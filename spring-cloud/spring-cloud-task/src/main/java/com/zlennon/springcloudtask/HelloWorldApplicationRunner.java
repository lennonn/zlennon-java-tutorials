package com.zlennon.springcloudtask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public  class HelloWorldApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments arg0)
            throws Exception {
        // TODO Auto-generated method stub
        log.info("Hello World from Spring Cloud Task!");
    }
}