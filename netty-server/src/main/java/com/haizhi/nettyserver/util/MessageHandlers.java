package com.haizhi.nettyserver.util;

import com.haizhi.nettyserver.handler.DefaultHandler;
import com.haizhi.nettyserver.handler.IMessageHandler;

import java.util.HashMap;
import java.util.Map;

public class MessageHandlers {

    private static Map<String, IMessageHandler<?>> handlers = new HashMap<>();
    public static DefaultHandler defaultHandler = new DefaultHandler();

    public static void register(String type, IMessageHandler<?> handler) {
        handlers.put(type, handler);
    }

    public static IMessageHandler<?> get(String type) {
        IMessageHandler<?> handler = handlers.get(type);
        return handler;
    }

}
