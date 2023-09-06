package com.zlennon.concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TheadPoolExecutorTest {


    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int COUNT_MASK = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~COUNT_MASK; }
    private static int workerCountOf(int c)  { return c & COUNT_MASK; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }

    @Test
    public void testFiledOfTheadPoolExecutor() {
        System.out.println("COUNT_BITS:"+ COUNT_BITS);
        System.out.println("COUNT_MASK:"+ COUNT_MASK);
        System.out.println("RUNNING:"+ RUNNING);
        System.out.println("SHUTDOWN:"+ SHUTDOWN);
        System.out.println("STOP:"+ STOP);
        System.out.println("TIDYING:"+ TIDYING);
        System.out.println("TERMINATED:"+ TERMINATED);
        int ss=1<<3;
        System.out.println("1<<2:"+ss);
    }
}
