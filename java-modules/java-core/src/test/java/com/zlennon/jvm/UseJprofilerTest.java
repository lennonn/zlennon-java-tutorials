package com.zlennon.jvm;


import org.junit.Test;

public class UseJprofilerTest {
    @Test
    public void test(){
        try {
            UseJProfiler.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
