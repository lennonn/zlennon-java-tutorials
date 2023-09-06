package com.zlennon.concurrency;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    @Test
    public void testPark() throws InterruptedException {
        System.out.println("start ...");
        //Thread.currentThread().interrupt();
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.parkNanos(Thread.currentThread(),1000000000);
            System.out.println("park ...");
        });
        thread.setName("park");
        thread.start();
        //Thread.sleep(2000);
        Object blocker = LockSupport.getBlocker(thread);
        System.out.println(blocker.toString());
    }
}
