package com.vnext.w18socket.netty04;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author leo
 * @version 2018/6/12 6:05
 * @since 1.0.0
 */
public class EchoServerInHandler1 extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerInHandler1...channelActive......");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("EchoServerInHandler1......channelRead");
        // 用 fireChannelRead 发送到下一个 InboundHandler
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerInHandler1...channelReadComplete......");
        ctx.flush();  // 刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoServerInHandler1...exceptionCaught......");
        cause.printStackTrace();
        ctx.close();
    }
}