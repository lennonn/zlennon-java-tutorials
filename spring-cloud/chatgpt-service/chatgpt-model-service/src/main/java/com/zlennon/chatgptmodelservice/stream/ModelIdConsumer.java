package com.zlennon.chatgptmodelservice.stream;

import com.zlennon.chatgptmodelservice.entity.Model;
import com.zlennon.chatgptmodelservice.repository.ModelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Profile("rabbit")
@Configuration
@Slf4j
public class ModelIdConsumer {

    @Autowired
    ModelRepository modelRepository;
/*
    @Autowired
    StreamBridge streamBridge;

    @Bean
    @Profile("rabbit")
    public Consumer<String> modelId() {
        return id->{
            log.info("getModelId:{}", id);
            //Model model = modelRepository.findById(id).get();
            Model model = new Model();
            model.setId(id);
            model.setObject("士大夫");
            streamBridge.send("modelInfo-out-0",model);
        };
    }*/
}
