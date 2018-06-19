package com.vnext.w14multi.m04future;

/**
 * @author leo
 * @version 2018/2/10 19:54
 * @since 1.0.0
 */
public class Test {

    public static void main(String[] args) throws Exception {
        long l = System.currentTimeMillis();
        FutureClient fClient = new FutureClient();
        Data data = fClient.request("[项目列表]");

        System.out.println("请求发送成功...可以做其他事情了...");

        System.out.println("开始做其他事情....泡茶...");
        Thread.sleep(2000);
        System.out.println("泡茶...花了2秒时间...");

        String result = data.getRequest();

        System.out.println("获取到的真实数据:" + result);
        long l1 = System.currentTimeMillis();
        System.out.println("整个过程总共花了：" + (l1 - l) + " 毫秒");
    }
}
