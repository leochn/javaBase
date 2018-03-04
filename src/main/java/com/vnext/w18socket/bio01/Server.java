package com.vnext.w18socket.bio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author leo
 * @version 2018/3/3 17:08
 * @since 1.0.0
 */
public class Server {

    final static int PROT = 8765;

    public static void main(String[] args) {

        ServerSocket server = null;
        try {
            server = new ServerSocket(PROT);
            System.out.println("server start .. ");
            //server端启动后，会在这里进行阻塞，等待client端的连接
            Socket socket = server.accept();

            System.out.println("server accept...");
            // 连接client后,新建一个线程执行客户端的任务
            new Thread(new ServerHandler(socket)).start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null){
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            server = null;
        }
    }
}
