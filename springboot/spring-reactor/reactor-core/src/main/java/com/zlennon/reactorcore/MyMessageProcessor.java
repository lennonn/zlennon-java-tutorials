package com.zlennon.reactorcore;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyMessageProcessor {
    private MyMessageListener myMessageProcessor;

    public List<String> getHistory(long n) {
        return null;
    }

    public void register(MyMessageListener<String> myMessageProcessor) {
        this.myMessageProcessor = myMessageProcessor;
    }
}
