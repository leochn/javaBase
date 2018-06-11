package com.vnext.w18socket.bio03;

import java.io.*;
import java.net.Socket;

/**
 * @author leo
 * @version 2018/6/10 16:43
 * @since 1.0.0
 */
public class ServiceClient {

    public static void main(String[] args) throws Exception{

        // 向服务端发出请求建立连接
        Socket socket = new Socket("localhost",8899);
        // 从socket中获取输入输出流
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.println("{service:com.vnext.w18socket.bio03.GetDataServiceImpl,method:getData,params:helloServerSocket}");
        printWriter.flush();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String result = bufferedReader.readLine();
        System.out.println("received server response --> " + result);

        inputStream.close();
        outputStream.close();
        socket.close();


    }

}