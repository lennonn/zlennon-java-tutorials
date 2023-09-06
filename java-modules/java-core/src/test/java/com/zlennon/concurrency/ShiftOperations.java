package com.zlennon.concurrency;

import org.junit.Test;

public class ShiftOperations {
    @Test
    public void testLeftShift(){
        int  TERMINATED   = 1 << 25;
        int STOP         = 1 << 31;       // must be negative
        int UNCOMPENSATE = 1 << 16;
        System.out.println(TERMINATED +"="+STOP +"="+UNCOMPENSATE);
    }



}
