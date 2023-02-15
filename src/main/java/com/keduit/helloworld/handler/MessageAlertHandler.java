package com.keduit.helloworld.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@Component
@Log4j2
@RequiredArgsConstructor
public class MessageAlertHandler extends TextWebSocketHandler {

    HashMap<Integer, WebSocketSession> sessionMap = new HashMap<>();

    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        //여기와서 발송됨
    }

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        //소켓 연결
        super.afterConnectionEstablished(session);

        sessionMap.put(1, session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        //소켓 종료
        if(sessionMap.size() > 0) { //소켓이 종료되면 해당 세션값들을 찾아서 지운다.
            for(int i = 0; i < sessionMap.size(); i++) {
                sessionMap.remove(session.getId());
            }
        }
        super.afterConnectionClosed(session, status);
    }
}
