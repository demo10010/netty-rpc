package com.haizhi.nettyserver.encoder;

import com.google.common.base.Charsets;
import com.haizhi.nettyserver.util.MessageInput;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

public class MessageDecoder extends ReplayingDecoder<MessageInput> {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        String requestId = readStr(in);
        String type = readStr(in);
        String content = readStr(in);
        out.add(new MessageInput(type, requestId, content));
    }

    private String readStr(ByteBuf in) {
        // 字符串限制长度,并转换为字节数组，统一UTF8编码
        int len = in.readInt();
        if (len < 0 || len > (1 << 20)) {
            throw new DecoderException("string too long len=" + len);
        }
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        return new String(bytes, Charsets.UTF_8);//对消息进行编码
    }

}
