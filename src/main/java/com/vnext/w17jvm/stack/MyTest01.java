package com.vnext.w17jvm.stack;

/**
 * 栈 调用最大深度测试
 * @author leo
 * @version 2018/3/2 21:20
 * @since 1.0.0
 */
public class MyTest01 {

    // JVM 配置
    // -Xss1m
    // -Xss5m

    //栈调用深度
    private static int count;

    public static void recursion(){
        count++;
        recursion();
    }
    public static void main(String[] args){
        try {
            recursion();
        } catch (Throwable t) {
            System.out.println("调用最大深入：" + count);
            t.printStackTrace();
        }
    }
}
