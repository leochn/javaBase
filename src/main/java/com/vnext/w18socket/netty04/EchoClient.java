package com.vnext.w18socket.netty04;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author leo
 * @version 2018/6/12 6:00
 * @since 1.0.0
 */
public class EchoClient {

    private final String host;
    private final int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws Exception {

        EventLoopGroup eventLoopGroup = null;
        try {
            // server端引导类
            Bootstrap bootstrap = new Bootstrap();
            // EventLoopGroup 可以理解为是一个线程池，这个线程池用来处理连接，接收数据
            eventLoopGroup = new NioEventLoopGroup();
            bootstrap.group(eventLoopGroup) // 多线程处理
                    .channel(NioSocketChannel.class) // 指定通道类型
                    .remoteAddress(host,port)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            channel.pipeline().addLast(new EchoClientHandler());
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect().sync();

            // 等待channel 关闭，因为sync(),所以关闭操作会被阻塞
            channelFuture.channel().closeFuture().sync();
        } finally {
            // 阻塞等待线程组关闭
            eventLoopGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws Exception {
        new EchoClient("localhost",20000).start();
    }
}