package com.zlennon.reactorcore.errorshandle;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class ExceptionHandling {

    public void handleException(){
        Flux<String> s = Flux.range(1, 10)
                .map(this::doSomethingDangerous)
                .map(this::doSecondTransform);
        s.subscribe(value -> System.out.println("RECEIVED " + value),
                error -> System.err.println("CAUGHT " + error)
        );
    }

    private String doSecondTransform(Object v) {
        return "do "+v;
    }

    private Object doSomethingDangerous(Integer v) {
        return v/0;
    }
}
