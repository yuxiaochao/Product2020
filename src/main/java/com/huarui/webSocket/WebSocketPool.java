package com.huarui.webSocket;

import java.util.concurrent.ConcurrentHashMap;

/**
 * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
 */
public class WebSocketPool {

    private static ConcurrentHashMap<String, WebSocketServer> webSocketMap = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<String, WebSocketServer> getWebSocketMap() {
        return webSocketMap;
    }

    public static void setWebSocketMap(ConcurrentHashMap<String, WebSocketServer> webSocketMap) {
        WebSocketPool.webSocketMap = webSocketMap;
    }
}
