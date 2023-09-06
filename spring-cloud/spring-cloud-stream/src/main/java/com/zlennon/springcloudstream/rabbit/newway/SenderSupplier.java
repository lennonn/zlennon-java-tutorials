package com.zlennon.springcloudstream.rabbit.newway;

import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Configuration
public class SenderSupplier {

    private final StreamBridge streamBridge;

    public SenderSupplier(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(String modelId){
            streamBridge.send("modelId-out-0", modelId);
    }


    @Bean
    public Supplier<String> modelId(){
        return ()->"modelId";
    }
}
