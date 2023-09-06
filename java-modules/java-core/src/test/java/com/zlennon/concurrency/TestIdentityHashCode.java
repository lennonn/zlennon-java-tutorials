package com.zlennon.concurrency;

import org.junit.Test;

public class TestIdentityHashCode {


    @Test
    public void testIdentityHashCode(){
        TestIdentityHashCode identityHashCode = new TestIdentityHashCode();
        TestIdentityHashCode identityHashCode1 = new TestIdentityHashCode();
        System.out.println( System.identityHashCode(identityHashCode));
        System.out.println( System.identityHashCode(identityHashCode1));
    }
}
