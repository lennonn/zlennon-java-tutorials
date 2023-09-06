package com.zlennon.atomic;


import org.junit.Test;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportTest {
    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock =new ReentrantLock();
        Thread main = Thread.currentThread();
        new Thread(()->{
            try {
                for (int i = 0; i < 5; i++) {

                    Thread.sleep(2000);
                    LockSupport.unpark(main);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        int postSpins=0;
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            int spins = postSpins = (byte)((postSpins << 1) | 1);
            System.out.println("spins: " + spins);
            LockSupport.park();
        }
    }
}
