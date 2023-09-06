package com.zlennon.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private  AtomicInteger mum = new AtomicInteger(0);
    private int threadCounts=10;

    public void increase(int j) {
        mum.incrementAndGet();
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"循环次数"+j);
    }


    public int addNumber() {
        CountDownLatch countDownLatch = new CountDownLatch(threadCounts);
        for (int i = 0; i < threadCounts; i++) {
             new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    increase(j);
                }
                 countDownLatch.countDown();
             },"thread-"+i).start();
        }
        try {
            countDownLatch.await();//等待所有的线程执行完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mum.get();
    }

    public static void main(String[] args) {
        AtomicIntegerTest aiTest = new AtomicIntegerTest();
        System.out.println(aiTest.addNumber());
    }
}
