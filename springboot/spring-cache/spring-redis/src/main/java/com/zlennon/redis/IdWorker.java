
package com.zlennon.redis;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * ID生成器(雪花算法)
 * @author dengjiachang
 *
 */
@Component
public class IdWorker implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static String nextStringId() {
        return applicationContext.getBean(IdWorderComponent.class).nextStringId();
    }

    public static long nextLongId() {
        return applicationContext.getBean(IdWorderComponent.class).nextLongId();
    }

    //    private final long workerId;
//
//    private final static long twepoch = 1288834974657L;
//
//    private long sequence = 0L;
//
//    private final static long workerIdBits = 4L;
//
//    public final static long maxWorkerId = -1L ^ -1L << workerIdBits;
//
//    private final static long sequenceBits = 10L;
//
//    private final static long workerIdShift = sequenceBits;
//
//    private final static long timestampLeftShift = sequenceBits + workerIdBits;
//
//    public final static long sequenceMask = -1L ^ -1L << sequenceBits;
//
//    private long lastTimestamp = -1L;
//
//    private static IdWorker idWorker = new IdWorker(1);
//
//    public IdWorker(final long workerId) {
//        super();
//        if (workerId > this.maxWorkerId || workerId < 0) {
//            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
//        }
//        this.workerId = workerId;
//    }
//
//    public synchronized long nextId() {
//        long timestamp = this.timeGen();
//        if (this.lastTimestamp == timestamp) {
//            this.sequence = (this.sequence + 1) & this.sequenceMask;
//            if (this.sequence == 0) {
//                System.out.println("###########" + sequenceMask);
//                timestamp = this.tilNextMillis(this.lastTimestamp);
//            }
//        }
//        else {
//            this.sequence = 0;
//        }
//        if (timestamp < this.lastTimestamp) {
//            try {
//                throw new Exception(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
//            }
//            catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        this.lastTimestamp = timestamp;
//        long nextId = ((timestamp - twepoch << timestampLeftShift)) | (this.workerId << this.workerIdShift) | (this.sequence);
//        return nextId;
//    }
//
//    private long tilNextMillis(final long lastTimestamp) {
//        long timestamp = this.timeGen();
//        while (timestamp <= lastTimestamp) {
//            timestamp = this.timeGen();
//        }
//        return timestamp;
//    }
//
//    public static String nextStringId() {
//        return String.valueOf(idWorker.nextId());
//    }
//
//    public static long nextLongId() {
//        return idWorker.nextId();
//    }
//
//    private long timeGen() {
//        return System.currentTimeMillis();
//    }
}
