package com.zlennon.springintegration.basic.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.*;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Configuration
public class ChannelConfig {

    @Bean
    public MessageChannel inputChannel(){
       return  new DirectChannel();
    }

    @Bean
    public QueueChannel outputChannel(){
        return  new QueueChannel(10);
    }

    @EndpointId("loggerAdapter")
    @InboundChannelAdapter(channel = "logger", poller = @Poller(fixedDelay = "100000",maxMessagesPerPoll="20"))
    public String loggerAdapter() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    @Bean
    public MessageChannel logger() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "logger")
    public LoggingHandler logging() {
        LoggingHandler adapter = new LoggingHandler(LoggingHandler.Level.INFO);
        adapter.setLoggerName("test logger");
        adapter.setLogExpressionString("headers.id + ': ' + payload");
        return adapter;
    }

    @MessagingGateway(defaultRequestChannel = "logger")
    public interface LoggerGateway {
        void sendToLogger(String data);

    }
}
