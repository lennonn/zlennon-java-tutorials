package com.zlennon.websocketclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.apache.commons.lang3.ThreadUtils.sleep;

@Service
public class SendMsgService{

    CountDownLatch count = new CountDownLatch(1);

    public String send() throws IOException, ExecutionException, InterruptedException {
        String url = "ws://localhost:6002/user";

        StandardWebSocketClient webSocketClient = new StandardWebSocketClient();
        SocketTextHandler handler = new SocketTextHandler(count);
        WebSocketSession session = webSocketClient.doHandshake(handler, url).get();

        // 发送消息
        String message = "Hello, WebSocket!";
        session.sendMessage(new TextMessage(message));
        // 关闭WebSocket连接
        session.close();
        count.await();
        String msg = handler.msg;
        return msg;

    }


}
