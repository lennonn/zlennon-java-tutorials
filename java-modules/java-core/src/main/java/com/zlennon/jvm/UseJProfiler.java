package com.zlennon.jvm;

public class UseJProfiler {
    public static void test() throws InterruptedException {
        double result =0;
        for(int i=0;i<Long.MIN_VALUE;i++){
            result=result+i;
            byte[] var = new byte[4*1024*1024];
            Thread.sleep(5*1000*1000*1000);
            System.gc();
        }
        System.out.println(result);
    }
}
