package com.haizhi.nettyserver.handler;

import com.haizhi.nettyserver.util.MessageInput;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

// 找不到类型的消息统一使用默认处理器处理
@Slf4j
public class DefaultHandler implements IMessageHandler<MessageInput> {

    @Override
    public void handle(ChannelHandlerContext ctx, String requesetId, MessageInput input) {
        log.info("unrecognized message type=" + input.getType() + " comes");
    }

}
