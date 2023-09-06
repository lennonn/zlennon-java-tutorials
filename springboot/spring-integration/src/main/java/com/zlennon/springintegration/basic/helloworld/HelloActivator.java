package com.zlennon.springintegration.basic.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class HelloActivator {


    @Autowired
    HelloService helloService;

    @ServiceActivator(inputChannel = "inputChannel",outputChannel="outputChannel")
    public String sayHello(String name) {
       return  helloService.sayHello(name);
    }

}
