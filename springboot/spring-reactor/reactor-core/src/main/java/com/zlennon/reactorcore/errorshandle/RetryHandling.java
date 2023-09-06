package com.zlennon.reactorcore.errorshandle;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Component
public class RetryHandling {

    public void retryNTimes(int n){
        Flux.interval(Duration.ofMillis(250))
                .map(input -> {
                    if (input < 5) return "tick " + input;
                    throw new RuntimeException("boom");
                })
                .retry(n)
                .elapsed()
                .subscribe(System.out::println, System.err::println);

        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
