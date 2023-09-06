package com.zlennon.websocketclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

    String msg;
    CountDownLatch countDownLatch;

    public SocketTextHandler(CountDownLatch count) {
        this.countDownLatch=count;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        log.info("from socker server:{}",payload);
        this.msg=payload;
        countDownLatch.countDown();
    }

}
