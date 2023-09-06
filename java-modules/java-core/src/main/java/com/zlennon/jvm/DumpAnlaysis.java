package com.zlennon.jvm;

public class DumpAnlaysis {
    private static Object object = new Object();
    public void blockedState() {
        Runnable task = () -> {
            synchronized (object) {
                long begin = System.currentTimeMillis();

                long end = System.currentTimeMillis();

                // 让线程运行5分钟,会一直持有object的监视器
                while ((end - begin) <= 5 * 60 * 1000) {

                }
            }
        };
        new Thread(task, "t1").start();
        new Thread(task, "t2").start();
    }
    public void deadLockState() {
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";

        Thread t1 = new Thread(() -> {
            synchronized(resource1){
                System.out.println("Thread1:locked resource1");
                try{
                    Thread.sleep(50);
                }catch(Exception ex){

                }
                synchronized(resource2){
                    System.out.println("Thread1:locked resource2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized(resource2){
                System.out.println("Thread2:locked resource2");
                try{
                    Thread.sleep(50);
                }catch(Exception ex){

                }
                synchronized(resource1){
                    System.out.println("Thread2:locked resource1");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        DumpAnlaysis da= new DumpAnlaysis();
        da.deadLockState();
    }
}
