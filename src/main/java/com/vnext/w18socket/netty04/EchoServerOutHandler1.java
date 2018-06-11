package com.vnext.w18socket.netty04;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * @author leo
 * @version 2018/6/12 6:05
 * @since 1.0.0
 */
public class EchoServerOutHandler1 extends ChannelHandlerAdapter {

    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        System.out.println("EchoServerOutHandler1.....write------");
        System.out.println(msg);

        ctx.write(msg);
        ctx.flush();
    }

}