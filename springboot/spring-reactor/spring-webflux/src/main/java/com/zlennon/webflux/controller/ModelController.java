package com.zlennon.webflux.controller;

import com.zlennon.webflux.entity.Model;
import com.zlennon.webflux.repository.ModelRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@Slf4j
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelRepository modelRepository;


    @GetMapping("/{id}")
    public Mono<Model> getModelById(@PathVariable String id) {
        return modelRepository.findById(id);
    }

    @RequestMapping("/all")
    public Flux<Model> getAllModels(HttpServletRequest request){
        return modelRepository.findAll();

    }
}
