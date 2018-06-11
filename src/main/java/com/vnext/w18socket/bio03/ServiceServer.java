package com.vnext.w18socket.bio03;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leo
 * @version 2018/6/10 18:47
 * @since 1.0.0
 */
public class ServiceServer {

    public static void main(String[] args) throws Exception{

        // 创建serversocket,绑定到本机的8899端口上
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost",8899));
        System.out.println("server start ......");

        // 接收客户端的连接请求，accept是一个阻塞的方法，会一直等待，到有客户端请求连接才返回
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(new ServiceServerTask(socket)).start();
        }
    }

}