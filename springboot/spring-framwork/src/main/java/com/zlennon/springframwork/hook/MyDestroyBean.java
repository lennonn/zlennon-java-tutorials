package com.zlennon.springframwork.hook;


import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class MyDestroyBean {
    @PreDestroy
    public void destroy() {
        System.out.println("Callback triggered - @PreDestroy MyDestroyBean destroy");
    }
}
