package com.vnext.w18socket.bio03;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author leo
 * @version 2018/6/10 18:55
 * @since 1.0.0
 */
public class ServiceServerTask implements Runnable {

    Socket socket;
    InputStream inputStream;
    OutputStream outputStream;

    public ServiceServerTask(Socket socket) {
        this.socket = socket;
    }

    // 业务逻辑，跟客户端进行数据交互
    @Override
    public void run() {

        try {
            System.out.println("Server服务现场启动......");

            // 从socket连接中获取与client之间的网络通信输入输出流
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            // 从网络通信输入流中读取客户端发送过来的数据
            // 注意：socketinputstream的读数据的方法都是阻塞的
            String param = bufferedReader.readLine();
            System.out.println("server received --> " + param);

            Gson gson = new Gson();
            HashMap fromJson = gson.fromJson(param, HashMap.class);
            String serviceName = (String) fromJson.get("service");
            String methodName = (String) fromJson.get("method");
            String params = (String) fromJson.get("params");
            Class<?> clazz = Class.forName(serviceName);
            Method method = clazz.getMethod(methodName, String.class);
            String result = (String) method.invoke(clazz.newInstance(), params);

            // 将调用结果写到socket的输出流中，以发送给客户端
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println(result);
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}