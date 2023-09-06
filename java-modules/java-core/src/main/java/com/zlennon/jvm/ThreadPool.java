package com.zlennon.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.submit(()->{
            System.out.println("thread"+Thread.currentThread().getName());
        });
        executorService.shutdown();
        System.out.println(executorService.isShutdown()+"==="+executorService.isTerminated());
    }
}
