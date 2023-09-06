package com.zlennon.springcloudstream.rabbit.deprecated;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

public interface SinkSender {

    String OUTPUT = "modelId";

    @Output(SinkSender.OUTPUT)
    MessageChannel output();

}