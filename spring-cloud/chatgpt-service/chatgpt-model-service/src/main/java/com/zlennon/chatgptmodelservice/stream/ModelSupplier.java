package com.zlennon.chatgptmodelservice.stream;

import com.zlennon.chatgptmodelservice.entity.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.function.Supplier;

@Configuration
@Slf4j
public class ModelSupplier {

/*    private final StreamBridge streamBridge;

    public ModelSupplier(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    public void send(String modelId){
        streamBridge.send("modelInfo-in-0", modelId);
    }*/


    @Bean
    public Supplier<Model> modelInfo(){
        return ()->{
            //log.info("model Supplier ");
            return  new Model();
        } ;
    }

}
