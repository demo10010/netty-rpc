package com.haizhi.nettyserver.server;

import com.haizhi.nettyserver.util.ExpRequest;
import com.haizhi.nettyserver.util.ExpRequestHandler;
import com.haizhi.nettyserver.util.FibRequestHandler;

public class DemoServer {

    public static void main(String[] args) {
        RpcServer server = new RpcServer("127.0.0.1", 8555, 2, 16);
        server.service("fib", Integer.class, new FibRequestHandler())
                .service("exp", ExpRequest.class, new ExpRequestHandler());
        server.start();
    }

}
