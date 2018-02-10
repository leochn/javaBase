package com.vnext.w14multi;

/**
 * @author leo
 * @version 2018/2/10 19:54
 * @since 1.0.0
 */
public class FutureTest01 {
    public static void main(String[] args) {
        FutureClient fClient = new FutureClient();

        Data data = fClient.request("hello,world");

        System.out.println("请求发送成功...");
        System.out.println("干其他的事情...");

        String result = data.getRequest();

        System.out.println(result);
    }
}
