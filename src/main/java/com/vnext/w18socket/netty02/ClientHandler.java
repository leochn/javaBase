package com.vnext.w18socket.netty02;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;

/**
 * @author leo
 * @version 2018/3/3 22:31
 * @since 1.0.0
 */
public class ClientHandler extends ChannelHandlerAdapter {

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channel active... ");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            String response = (String)msg;
            System.out.println("Client: " + response);
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
