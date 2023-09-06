package com.zlennon.zookeeper;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class CalculateTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return IntStream.range(1,100000).sum();
    }


}
