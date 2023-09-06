package com.zlennon.resilience4j;

import com.zlennon.commonentity.model.Model;
import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.BulkheadFullException;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.retry.Retry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
@Slf4j
public class Resilience4jService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    RateLimiter rateLimiter;
    @Autowired
    Retry retry;

    @Autowired
    Bulkhead bulkhead;
    @Autowired
    ThreadPoolBulkhead threadPoolBulkhead;

    public ResponseEntity getAllModel(){
        log.info(Thread.currentThread().getName()+ "===> getAllModel");
        String url="http://127.0.0.1:7999/chatgpt/getAllModel";
        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("specificCustomConfiguration1");
        List<Model> models = circuitBreaker.run(() -> restTemplate.getForObject(url, List.class));
        return new ResponseEntity<>(models, HttpStatus.OK);
    }

    private List getDefaultModleList(Throwable throwable) {
        log.error("getDefaultModleList",throwable);
        List<Model> models= new ArrayList<>();
        Model model = new Model();
        model.setId("test");
        models.add(model);
        return models;
    }

    public ResponseEntity getChatGPTById(String id) {
        String url="http://127.0.0.1:7999/chatgpt/getChatGPTById/";
        Supplier<Model> model =
                RateLimiter.decorateSupplier(rateLimiter,
                        () ->  restTemplate.getForObject(url+""+id, Model.class));
        return new ResponseEntity<>(model.get(), HttpStatus.OK);
    }



    public ResponseEntity bulkhead(){

/*        bulkhead.getEventPublisher().onCallPermitted(event -> {
           log.info("onCallPermit==>>{}",event.toString()) ;
        });*/

        bulkheadCheckFunction();
        //bulkheadUseForkJoinPool();
        //threadPoolBulkhead();
        Integer response = 0;
        return new ResponseEntity(response, HttpStatus.OK);

    }

    public void threadPoolBulkhead(){
        Consumer decorated = Bulkhead.decorateConsumer(bulkhead, i -> {
            log.info("call time :{},thread:{},call time:{}", LocalDateTime.now(), Thread.currentThread().getName(),i);
            try {
                int i1 = 1 / 0;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for (int i=0; i<100; i++) {
            int finalI = i;
            threadPoolBulkhead.submit(() -> decorated.accept(finalI))
                    .exceptionally(t-> {
                        System.out.println("submit execute error:{}"+t.getMessage());
                        return null;
                    });
        }
    }

    public void bulkheadUseForkJoinPool(){
        Consumer decorated = Bulkhead.decorateConsumer(bulkhead, i -> {
            log.info("call time :{},thread:{},call time:{}", LocalDateTime.now(), Thread.currentThread().getName(),i);
            try {
                int i1 = 1 / 0;
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        for (int i=0; i<100; i++) {
            int finalI = i;
            forkJoinPool.submit(() -> decorated.accept(finalI));
        }
    }

    public void  bulkheadCheckFunction(){


        CheckedFunction0<String> checkedFunction0 = Bulkhead.decorateCheckedSupplier(bulkhead, this::process);

        for (int i=0; i<20; i++) {
            int finalI = i;
            threadPoolBulkhead.submit(()->{
                Try<String> result = Try.of(checkedFunction0)
                        .recover(BulkheadFullException.class, throwable -> {
                            log.info("服务失败: " + throwable.getLocalizedMessage());
                            return "0";
                        });
            });
        }

    }

    public String process(){
        try {
            Thread.sleep(2000);
            return LocalTime.now() + "process finished = " + Thread.currentThread().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public ResponseEntity retry() {
        CheckedFunction0<List<Model>> retryableSupplier = Retry.decorateCheckedSupplier(retry,this::fail);
        Try<List<Model>> result = Try.of(retryableSupplier).recover(this::getDefaultModleList);
        return new  ResponseEntity(result.get(),HttpStatus.OK);

    }

    List<Model> fail() {
        log.info("fail executed");
       String url="http://127.0.0.1:7999/chatgpt/getAllModel";
       return restTemplate.getForObject(url, List.class);
    }

    void  fallbackMethod(){
        System.out.println(Thread.currentThread().getName()+ " fallbackMethod");
    }

}
