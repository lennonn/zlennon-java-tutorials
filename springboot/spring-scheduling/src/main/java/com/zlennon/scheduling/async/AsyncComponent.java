package com.zlennon.scheduling.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Slf4j
public class AsyncComponent {

   // @Async
    public void asyncMethodWithVoidReturnType() {
        log.info("{} Execute method asynchronously. " ,Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncMethodWithReturnType() {
        log.info("{} Execute method asynchronously. " ,Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<>("hello world !!!!");
        } catch (final InterruptedException e) {

        }

        return null;
    }

    @Async("threadPoolTaskExecutor")
    public void asyncMethodWithConfiguredExecutor() {
        log.info("{} Execute method asynchronously with configured executor. " ,Thread.currentThread().getName());
    }

    @Async
    public void asyncMethodWithExceptions() throws Exception {
        throw new Exception("Throw message from asynchronous method. ");
    }

}
