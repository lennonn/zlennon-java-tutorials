package com.zlennon.concurrency.test;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantTest {
    @Test
    public void test() throws InterruptedException {
        ReentrantLock lock =new ReentrantLock();
        for (int i = 0; i < 4; i++) {
           Thread thread =new Thread(() -> {
               lock.lock();
               System.out.println(Thread.currentThread().getName() + "");
               try {
                   Thread.sleep(10000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               lock.unlock();
            });
            thread.setName("queue"+i);
            thread.start();
            Thread.sleep(500);
        }
        Thread.sleep(3000000);
    }

    int seed=0;
    @Test
    public void testRandom(){

        seed = seed+1;
        System.out.println(seed);
    }

    @Test
    public void test3(){
        ReentrantTest reentrantTest = new ReentrantTest();
        for (int i = 0; i <1000 ; i++) {
            reentrantTest.testRandom();
        }
    }
}
