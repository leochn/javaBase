package com.vnext.w18socket.netty04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * @author leo
 * @version 2018/6/12 6:05
 * @since 1.0.0
 */
public class EchoServerInHandler2 extends ChannelHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerInHandler2...channelActive");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("EchoServerInHandler2......channelRead");
        ByteBuf buf = (ByteBuf) msg;
        byte[] bytes = new byte[buf.readableBytes()];
        buf.readBytes(bytes);
        String body = new String(bytes,"utf-8");
        System.out.println("接收客户端数据：" + body);
        // 向客户端写数据
        System.out.println("server 向 client 发送数据");
        String currentTime = new Date(System.currentTimeMillis()).toString();
        ByteBuf byteBuf = Unpooled.copiedBuffer(currentTime.getBytes());
        ctx.write(byteBuf);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("EchoServerInHandler2......channelReadComplete");
        ctx.flush();  // 刷新后才将数据发出到SocketChannel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoServerInHandler2......exceptionCaught");
        cause.printStackTrace();
        ctx.close();
    }
}