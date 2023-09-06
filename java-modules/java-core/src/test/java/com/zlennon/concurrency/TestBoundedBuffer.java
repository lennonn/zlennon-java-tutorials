package com.zlennon.concurrency;

import org.junit.Assert;
import org.junit.Test;

/**
 * TestBoundedBuffer
 * <p/>
 * Basic unit tests for BoundedBuffer
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestBoundedBuffer {
    private static final long LOCKUP_DETECT_TIMEOUT = 1000;
    private static final int CAPACITY = 10000;
    private static final int THRESHOLD = 10000;

    @Test
    public void testIsEmptyWhenConstructed() {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Assert.assertTrue(bb.isEmpty());
        Assert.assertFalse(bb.isFull());
    }

    @Test
    public void  testIsFullAfterPuts() throws InterruptedException {
        SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        for (int i = 0; i < 10; i++)
            bb.put(i);
        Assert.assertTrue(bb.isFull());
        Assert.assertFalse(bb.isEmpty());
    }


    @Test
    public void testTakeBlocksWhenEmpty() {
        final SemaphoreBoundedBuffer<Integer> bb = new SemaphoreBoundedBuffer<Integer>(10);
        Thread taker = new Thread(() -> {
            try {
                System.out.println("taker thread start");
                int unused = bb.take();
                System.out.println("if we get here, it's an error");
                Assert.fail(); // if we get here, it's an error
            } catch (InterruptedException success) {
                System.out.println("111");
            }
        });
        try {
            taker.start();
            Thread.sleep(LOCKUP_DETECT_TIMEOUT);
            taker.interrupt();
            System.out.println(taker.isInterrupted());
            taker.join(LOCKUP_DETECT_TIMEOUT);
            System.out.println(taker.isAlive());
            Assert.assertFalse(taker.isAlive());
        } catch (Exception unexpected) {
            System.out.println("unexpected");
            Assert.fail();
        }
    }

    @Test
    public void testLeak() throws InterruptedException {
        SemaphoreBoundedBuffer<Big> bb = new SemaphoreBoundedBuffer<Big>(CAPACITY);
        int heapSize1 = snapshotHeap();
        for (int i = 0; i < CAPACITY; i++)
            bb.put(new Big());
        for (int i = 0; i < CAPACITY; i++)
            bb.take();
        int heapSize2 = snapshotHeap();
        Assert.assertTrue(Math.abs(heapSize1 - heapSize2) < THRESHOLD);
    }

    private int snapshotHeap() {
        /* Snapshot heap and return heap size */
        return 0;
    }

    static class Big {
        double[] data = new double[100000];
    }

}
