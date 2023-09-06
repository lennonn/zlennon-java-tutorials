package com.zlennon.reactorcore.subscriber;

import com.zlennon.reactorcore.create.FluxMonoCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class FluxMonoSubcriber {

    @Autowired
    FluxMonoCreator fluxMonoCreator;

    public void subscribeFlux(){
        Flux<String> fluxUseJust = fluxMonoCreator.createFluxUseJust();
        fluxUseJust.subscribe(s -> System.out.println("subscribeFlux==>"+s));
    }

    public void subscribeMono(){
        Mono<String> monoUseJust = fluxMonoCreator.createMonoUseJust();
        monoUseJust.subscribe(s -> System.out.println("subscribeMono==>"+s));
    }

    public void alphabetSubscribe(){
        Flux<String> fluxAlphabet = fluxMonoCreator.createFluxAlphabet();
        fluxAlphabet.subscribe(System.out::println);
    }

}
