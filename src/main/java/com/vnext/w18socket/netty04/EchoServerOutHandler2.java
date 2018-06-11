package com.vnext.w18socket.netty04;

import io.netty.channel.*;

/**
 * @author leo
 * @version 2018/6/12 6:05
 * @since 1.0.0
 */
public class EchoServerOutHandler2 extends ChannelHandlerAdapter {

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("EchoServerOutHandler2.....write------");
        ctx.write(msg); // 往下面一个发送
    }
}