package com.vnext.w18socket.netty02;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author leo
 * @version 2018/3/3 22:32
 * @since 1.0.0
 */
public class ServerHandler extends ChannelHandlerAdapter {

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" server channel active... ");
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String request = (String)msg;
        System.out.println("Server :" + msg);
        String response = "服务器响应：" + msg + "$_";
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
    }

    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t) throws Exception {
        ctx.close();
    }

}
