package com.zlennon.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanTest {
    private volatile boolean isStart;
    private AtomicBoolean atomicBooleanStart =new AtomicBoolean(false);

    public void start() {
        if(!isStart) {
            isStart = true;
            //do something
        }
    }

    public void stop() {
        if (atomicBooleanStart.compareAndSet(false, true)) {
            //doSomething
        }
    }
}
