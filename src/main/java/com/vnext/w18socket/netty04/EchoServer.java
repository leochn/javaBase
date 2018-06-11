package com.vnext.w18socket.netty04;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author leo
 * @version 2018/6/12 6:04
 * @since 1.0.0
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        EventLoopGroup eventLoopGroup = null;
        try {
            // server端引导类
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            // 连接池处理数据
            eventLoopGroup = new NioEventLoopGroup();
            serverBootstrap.group(eventLoopGroup).channel(NioServerSocketChannel.class)
                    .localAddress("localhost",port)
                    .childHandler(new ChannelInitializer<Channel>() {
                        @Override
                        protected void initChannel(Channel channel) throws Exception {
                            // 注册两个InboundHandler，执行顺序为注册顺序，所以应该是InboundHandler1，InboundHandler2
                            // 注册两个OutboundHandler，执行顺序为注册逆序，所以应该是OutboundHandler2，OutboundHandler1
                            channel.pipeline().addLast(new EchoServerInHandler1());
                            channel.pipeline().addLast(new EchoServerOutHandler1());
                            channel.pipeline().addLast(new EchoServerOutHandler2());
                            channel.pipeline().addLast(new EchoServerInHandler2());
                        }
                    });

            // 最后绑定服务器等待直到绑定成功，调用sync()方法会阻塞直到服务器完成绑定
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            System.out.println("开始监听，端口为：" + channelFuture.channel().localAddress());

            // 等待channel 关闭，因为sync(),所以关闭操作会被阻塞
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 阻塞等待线程组关闭
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoServer(20000).start();
    }
















}