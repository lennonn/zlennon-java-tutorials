package com.zlennon.jmh;


import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CoreConcepts {
    @Benchmark
    public void benchmark(){
        for (int i = 0; i <100 ; i++) {
           log.info("hello:==>{}",i);
        }
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void benchmarkMode(){
        for (int i = 0; i <10 ; i++) {
            log.info("benchmarkMode:==>{}",i);
        }
    }

    @Benchmark
    @Warmup(iterations = 5, time = 100, timeUnit =  TimeUnit.MILLISECONDS)
    public void warmup(){
        for (int i = 0; i <10 ; i++) {
            log.info("warmup:==>{}",i);
        }
    }

    @Benchmark
    @Measurement(iterations = 5, time = 100, timeUnit =  TimeUnit.MILLISECONDS)
    //基准测试运行5次迭代，每次迭代运行100毫秒
    public void measurement(){
        for (int i = 0; i <10 ; i++) {
            log.info("measurement:==>{}",i);
        }
    }

    @Benchmark
    @Fork(value = 5, warmups = 2)
    public void fork (){
        for (int i = 0; i <10 ; i++) {
            log.info("fork:==>{}",i);
        }
    }

}
