package com.zlennon.chatgptapiservice.stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class ModelIdConsumer {

    @Bean
    public Consumer<String> getModelId() {
        return System.out::println;
    }
}
