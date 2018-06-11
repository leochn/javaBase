package com.vnext.w18socket.netty04;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.ByteBuffer;

/**
 * @author leo
 * @version 2018/6/12 6:00
 * @since 1.0.0
 */
public class EchoClientHandler extends ChannelHandlerAdapter {

    // 客户端连接服务器后被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接服务器，开始发送数据......");
        byte[] req = "QUERY TIME ORDER".getBytes(); // 消息
        ByteBuf buffer = Unpooled.buffer(req.length); // 创建一个空的ByteBuf用于缓存即将发送的数据
        buffer.writeBytes(req);
        ctx.writeAndFlush(buffer);
    }

    // 从服务端接收到数据后调用
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("client 读取到server端的数据......");
        // 服务端返回消息后
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req,"utf-8");
        System.out.println("服务器数据为：" + body);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("EchoClientHandler...exceptionCaught......");
        cause.printStackTrace();
        ctx.close(); // 释放资源
    }
}