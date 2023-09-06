package com.zlennon.concurrency;

import com.zlennon.concurrency.forkjoin.NewTask;
import com.zlennon.concurrency.forkjoin.SumTask;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

public class ForkJoinPoolTest {
    @Test
  public void testForkJoin(){
      // get no. of available core available
      int proc = Runtime.getRuntime().availableProcessors();

      System.out.println("Number of available core in the processor is: "
              + proc);

      // get no. of threads active
      ForkJoinPool Pool = ForkJoinPool.commonPool();

      System.out.println("Number of active thread before invoking: "
              + Pool.getActiveThreadCount());

      NewTask t = new NewTask(1000000);

      Pool.invoke(t);

      System.out.println("Number of active thread after invoking: "
              + Pool.getActiveThreadCount());
      System.out.println("Common Pool Size is: "
              + Pool.getPoolSize());
  }

  @Test
    public void testSumTask(){
      // You can also use a generic thread pool provided by jdk8 ForkJoinPool.commonPool
      // You can specify the number of threads within the constructor
      ForkJoinPool forkJoinPool = new ForkJoinPool();
      long[] numbers = LongStream.rangeClosed(1, 100000000).toArray();
      // Here you can call the future returned by the submit method byFuture.getGet results
      Long result = forkJoinPool.invoke(new SumTask(numbers, 0, numbers.length - 1));
      System.out.println("Number of active threads:"+forkJoinPool.getActiveThreadCount());
      forkJoinPool.shutdown();
      System.out.println("The end result:"+result);
      System.out.println("Tasks stolen:"+forkJoinPool.getStealCount());
  }
}
