package com.zlennon.springcloudstream.rabbit.newway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream/rabbit")
@Slf4j
public class SendMessageController {

    @Autowired
    SenderSupplier senderSupplier;


    @RequestMapping("/send")
    public void send(String message) {
        senderSupplier.send(message);
        log.info("消息发送成功：{}",message);
    }

}
