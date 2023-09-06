package com.zlennon;

import org.junit.Test;

public class MultiParm {
    @Test
    public void test(){
        m();
    }

    public void m(int... a){
       System.out.println(a);
    }

    public void m(short... b){
        System.out.println(b);
    }
}
