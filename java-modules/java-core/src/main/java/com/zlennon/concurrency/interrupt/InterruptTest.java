package com.zlennon.concurrency.interrupt;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptTest {
    public static void test3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("青秧线程被中断，程序退出。");
                    System.out.println(Thread.currentThread().isInterrupted());
                    return;
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // System.out.println(Thread.currentThread().isInterrupted());
                    System.out.println("青秧线程休眠被中断，程序退出。");
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    public void testInterruptExeception() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                throw new RuntimeException("Thread interrupted..." + e);
            }
        });
        thread.start();
        thread.interrupt();
    }

    public void testInterruptExeception2() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("线程被打断 " + e);
            }
            System.out.println("线程继续运行。。。 ");
        });
        thread.start();
        thread.interrupt();
    }

    public void testInterruptExeception3() {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
            System.out.println("thread interrupt state:" + Thread.currentThread().isInterrupted());
        });
        thread.start();
        thread.interrupt();
    }

    public void testInterruptExeception4() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("任务停止，结束退出！");
                    return;
                }
                else
                    System.out.println("线程运行中。。。");
            }
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptTest interruptTest = new InterruptTest();
        //interruptTest.test3();
        interruptTest.testInterruptExeception4();
        ReentrantLock reentrantLock =new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        condition.await();
    }
}
