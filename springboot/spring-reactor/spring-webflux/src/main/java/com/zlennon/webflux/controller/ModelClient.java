package com.zlennon.webflux.controller;

import com.zlennon.webflux.entity.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class ModelClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(ModelClient.class);

    WebClient client = WebClient.create("http://localhost:9020");

    public void consume() {

        Mono<Model> employeeMono = client.get()
                .uri("/model/{id}", "ada")
                .retrieve()
                .bodyToMono(Model.class);

        employeeMono.subscribe(employee -> LOGGER.info("Model: {}", employee));

        Flux<Model> employeeFlux = client.get()
                .uri("/model/all")
                .retrieve()
                .bodyToFlux(Model.class)
                        .doOnNext(model -> System.out.println("onnext"));

        employeeFlux.subscribe(System.out::println);
    }
}
