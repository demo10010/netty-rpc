package com.haizhi.nettyclient.domian.qo;

public class RpcQo {

    private String requestId;
    private String type;
    private Object payload;

    public RpcQo(String requestId, String type, Object payload) {
        this.requestId = requestId;
        this.type = type;
        this.payload = payload;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getType() {
        return type;
    }

    public Object getPayload() {
        return payload;
    }

}

