package com.zlennon.scheduling.async;

import com.zlennon.scheduling.SpringSchedulingApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AsyncAnnotationExampleTest {

    @Autowired
    private AsyncComponent asyncAnnotationExample;

    // tests

    @Test
    public void testAsyncAnnotationForMethodsWithVoidReturnType() {
       log.info("Start - invoking an asynchronous method. thread name:{}" , Thread.currentThread().getName());
        asyncAnnotationExample.asyncMethodWithVoidReturnType();
       log.info("End - invoking an asynchronous method. ");
    }

    @Test
    public void testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
       log.info("Start - invoking an asynchronous method. thread name:{} " , Thread.currentThread().getName());
        final Future<String> future = asyncAnnotationExample.asyncMethodWithReturnType();

        while (true) {
            if (future.isDone()) {
               log.info("Result from asynchronous process - " + future.get());
                break;
            }
           log.info("Continue doing something else. ");
            Thread.sleep(1000);
        }
    }

    @Test
    public void testAsyncAnnotationForMethodsWithConfiguredExecutor() {
       log.info("Start - invoking an asynchronous method. ");
        asyncAnnotationExample.asyncMethodWithConfiguredExecutor();
       log.info("End - invoking an asynchronous method. ");
    }

    @Test
    public void testAsyncAnnotationForMethodsWithException() throws Exception {
       log.info("Start - invoking an asynchronous method. ");
        asyncAnnotationExample.asyncMethodWithExceptions();
       log.info("End - invoking an asynchronous method. ");
    }

}
