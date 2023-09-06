package com.zlennon.reactorcore;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class MyEventProcessor {
    private MyEventListener<String> eventListener;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public void register(MyEventListener<String> eventListener) {
        this.eventListener = eventListener;
    }


    public void processComplete() {
        executor.schedule(() -> eventListener.processComplete(),
                500, TimeUnit.MILLISECONDS);
    }

    public void onDataChunk(List<String> list) {
        executor.schedule(() -> eventListener.onDataChunk(list),
                500, TimeUnit.MILLISECONDS);
    }
}
