package com.zlennon.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantCondition {
    public void threadTest() {
        ReentrantLock lock = new ReentrantLock();
        Condition conditiona = lock.newCondition();
        Condition conditionb = lock.newCondition();
        Condition conditionc = lock.newCondition();
        AtomicInteger num = new AtomicInteger(3);
        Thread A = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if(num.get() % 3!= 0) {
                    try {
                        conditiona.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                num.getAndIncrement();
                conditionb.signal();
                lock.unlock();
            }
        });
        Thread B = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (num.get() %3 !=1) {
                    try {
                        conditionb.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }
                System.out.print("B");
                num.getAndIncrement();
                conditionc.signal();
                lock.unlock();
            }
        });
        Thread C = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                lock.lock();
                if (num.get() % 3 != 2) {
                    try {
                        conditionc.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num.getAndIncrement();
                System.out.println("C");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                conditiona.signal();
                lock.unlock();
            }
        });
        A.setName("A");
        A.start();
        B.setName("B");
        B.start();
        C.setName("C");
        C.start();
    }


    public static void main(String[] args) throws InterruptedException {
        ReentrantCondition test =new ReentrantCondition();
        test.threadTest();
    }
}
