package com.zlennon.springcloudstream.rabbit.deprecated;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;


public interface MySink {

    String INPUT = "modelId";

    @Input(MySink.INPUT)
    SubscribableChannel input();
}