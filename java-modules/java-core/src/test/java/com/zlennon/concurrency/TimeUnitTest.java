package com.zlennon.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class TimeUnitTest {
    @Test
    public void testConvert(){
        long seconds =TimeUnit.SECONDS.convert(1,TimeUnit.HOURS);
        //1小时转换为秒
        Assert.assertEquals(3600,seconds);
        //1分钟转为秒
        long minutes =TimeUnit.SECONDS.convert(1,TimeUnit.MINUTES);
        Assert.assertEquals(60,minutes);
    }
    @Test
    public void testConvertDuration(){
        long convert = TimeUnit.MILLISECONDS.convert(Duration.of(1, ChronoUnit.SECONDS));
        //1秒转换为毫秒
        Assert.assertEquals(1000,convert);
    }
    @Test
    public void testOf(){
        //1天转换为小时
        long hours = TimeUnit.of(ChronoUnit.DAYS).toHours(1);
        Assert.assertEquals(24,hours);
    }

    @Test
    public  void testTimeWait() throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
            long now = System.nanoTime();
            TimeUnit.SECONDS.timedWait(lock, 1);
            long nanos = System.nanoTime() - now;
            //1010055500 大约为1秒
            System.out.println(nanos);
        }
    }

    @Test
    public void testTimedJoin() throws InterruptedException {
        Thread t = new Thread(()->{
            for(;;){

            }
        });
        t.start();
        System.out.println("start wait");
        //子线程t等待10秒
        TimeUnit.SECONDS.timedJoin(t, 10);
        System.out.println("end wait");
    }
}
