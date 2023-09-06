package com.zlennon.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo implements Runnable{
    private static final AtomicInteger nextId = new AtomicInteger(0);
    private static final ThreadLocal<Integer> threadId = new ThreadLocal<>();

    public static int get() {
        return threadId.get();
    }

    public static void set() {
        threadId.set(nextId.incrementAndGet());
    }

    @Override
    public void run() {
        ThreadLocalDemo.set();
        System.out.println("Thread name=>" + Thread.currentThread().getName() + ":" + ThreadLocalDemo.threadId.get());
    }



    public static void main(String[] args) throws InterruptedException {
/*        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                ThreadLocalDemo.set();
                System.out.println("Thread name=>"+Thread.currentThread().getName()+":"+ThreadLocalDemo.threadId.get());
            },"Thread"+i);
            thread.start();
        }
        Thread.sleep(2000);
        System.out.println("Thread name"+Thread.currentThread().getName()+":"+ ThreadLocalDemo.nextId);*/
        ThreadLocalDemo threadLocalDemo =new ThreadLocalDemo();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i <3 ; i++) {
            threadPoolExecutor.execute(threadLocalDemo);
        }
        boolean flag=true;
        while (flag) {
            if (threadPoolExecutor.getCompletedTaskCount()==3) {
                threadPoolExecutor.execute(threadLocalDemo);
                flag=false;
            }
        }
        threadPoolExecutor.shutdown();
    }
}
