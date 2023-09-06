package com.zlennon.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个单线程的线程池
        ExecutorService single = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 3; i++) {
            single.submit(() -> {
                System.out.println(111);
                System.out.println("执行线程名字" + Thread.currentThread().getName());
            });
        }

        Thread.sleep(2000);
        System.out.println(single.isShutdown()+"==="+single.isTerminated());
    }
}
