package com.zlennon.springapplicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringApplicationEventApplication implements CommandLineRunner {


    @Autowired
    private  ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    private ApplicationContext applicationContext;


    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationEventApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        State state = new State();
        state.setState(10);
        //1 eventpublisher
       // applicationEventPublisher.publishEvent(new StateChangeEvent<>(state));
        //2 context
        // 发布事件，事件源为Context
        StateChangeEvent stateChangeEvent = new StateChangeEvent(applicationContext);
        stateChangeEvent.setData(state);
        applicationContext.publishEvent(stateChangeEvent);
    }
}
