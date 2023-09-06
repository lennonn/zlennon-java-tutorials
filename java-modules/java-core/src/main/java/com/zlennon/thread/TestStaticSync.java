package com.zlennon.thread;

public class TestStaticSync {
    private static int mum;
    public synchronized   static   void testSync(){
        System.out.println(Thread.currentThread().getName()+" synchronized start");
        mum++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" synchronized end");
    }

    public synchronized    void testSync2(){
        System.out.println(Thread.currentThread().getName()+" synchronized start");

        mum++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" synchronized end");

    }

    public static void main(String[] args) {
        TestStaticSync test1 = new TestStaticSync();
        TestStaticSync test2 = new TestStaticSync();
        //new Thread(TestStaticSync::testSync,"name1").start();
       // new Thread(TestStaticSync::testSync,"name2").start();
        new Thread(test1::testSync2,"name3").start();
        new Thread(test2::testSync2,"name4").start();
    }
}
