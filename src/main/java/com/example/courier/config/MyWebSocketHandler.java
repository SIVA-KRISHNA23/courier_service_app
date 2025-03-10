//package com.example.courier.config;
//
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.CloseStatus;
//
//
//public class MyWebSocketHandler extends TextWebSocketHandler {
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        // Logic after connection established
//        System.out.println("Connection established with: " + session.getId());
//    }
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        // Logic to handle received message
//        String payload = message.getPayload();
//        System.out.println("Received message: " + payload);
//        session.sendMessage(new TextMessage("Received: " + payload));
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        // Logic after connection closed
//        System.out.println("Connection closed: " + session.getId());
//    }
//
//    @Override
//    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
//        // Logic to handle transport errors
//        exception.printStackTrace();
//    }
//}
