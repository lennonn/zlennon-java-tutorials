package com.zlennon.springprogressbar;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;

@Component
@Slf4j
public class SocketTextHandler extends TextWebSocketHandler {

    static ArrayList<WebSocketSession> users = new ArrayList<WebSocketSession>();



    /**
     * 连接成功时候，会触发页面上onopen方法
     */
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connect to the websocket success......当前数量:"+users.size());
        users.add(session);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        users.remove(session);
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String payload = message.getPayload();
        //JSONObject jsonObject = JSONObject.parseObject(payload);
        session.sendMessage(new TextMessage(payload + " how may we help you?"));
    }


    public void sendMessageToAllSessions(String message) throws IOException {
        log.info("当前进度==>{}",message);
        for (WebSocketSession session : users) {
            session.sendMessage(new TextMessage(message));
        }
    }
}
