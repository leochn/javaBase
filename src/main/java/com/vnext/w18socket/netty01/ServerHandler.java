package com.vnext.w18socket.netty01;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author leo
 * @version 2018/3/3 21:33
 * @since 1.0.0
 */
public class ServerHandler extends ChannelHandlerAdapter {

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server channel active... ");
    }


    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("ServerHandler channelRead..............");
        ByteBuf buf = (ByteBuf) msg;
        byte[] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "utf-8");
        System.out.println("Server :" + body);
        String response = "进行返回给客户端的响应：" + body;
        ctx.writeAndFlush(Unpooled.copiedBuffer(response.getBytes()));
        //.addListener(ChannelFutureListener.CLOSE);
    }

    public void channelReadComplete(ChannelHandlerContext ctx)
            throws Exception {
        System.out.println("读完了");
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable t)
            throws Exception {
        ctx.close();
    }

}
