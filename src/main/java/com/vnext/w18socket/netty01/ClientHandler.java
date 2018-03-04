package com.vnext.w18socket.netty01;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author leo
 * @version 2018/3/3 21:34
 * @since 1.0.0
 */
public class ClientHandler extends ChannelHandlerAdapter {


    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ClientHandler channelRead .....................");
        try {
            ByteBuf buf = (ByteBuf) msg;

            byte[] req = new byte[buf.readableBytes()];
            buf.readBytes(req);

            String body = new String(req, "utf-8");
            System.out.println("Client :" + body );
            String response = "收到服务器端的返回信息：" + body;
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

}
