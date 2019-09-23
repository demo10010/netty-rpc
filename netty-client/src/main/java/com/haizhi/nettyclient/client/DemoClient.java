package com.haizhi.nettyclient.client;

import com.haizhi.nettyclient.util.ExpRequest;
import com.haizhi.nettyclient.util.ExpResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoClient {
    private RpcClient client;

    public DemoClient(RpcClient client) {
        this.client = client;
        // 注册服务返回类型
        this.client.rpc("fib_res", Long.class).rpc("exp_res", ExpResponse.class);
    }

    public long fib(int n) {
        return (Long) client.send("fib", n);
    }

    public ExpResponse exp(int base, int exp) {
        return (ExpResponse) client.send("exp", new ExpRequest(base, exp));
    }

    public static void main(String[] args) {
        RpcClient client = new RpcClient("127.0.0.1", 8555);
        DemoClient demo = new DemoClient(client);
        for (int i = 0; i < 2000; i++) {
            log.info("fib({}) = {} \n", i, demo.fib(i));
        }
        for (int i = 0; i < 2000; i++) {
            ExpResponse res = demo.exp(2, i);
            log.info("exp2({}) = {} cost= {} ns\n", i, res.getValue(), res.getCostInNanos());
        }
    }
}
