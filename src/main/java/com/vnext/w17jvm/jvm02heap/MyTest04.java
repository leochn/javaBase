package com.vnext.w17jvm.jvm02heap;

/**
 * @author leo
 * @version 2018/3/2 19:56
 * @since 1.0.0
 */
public class MyTest04 {

    public static void main(String[] args) {

        //-Xms5m -Xmx20m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:+PrintCommandLineFlags

        //查看GC信息
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory() / 1024/1024 + "M");
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/ 1024/1024+ "M");
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/ 1024/1024+ "M");

        byte[] b1 = new byte[1*1024*1024];
        System.out.println("分配了1M");
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory()/ 1024/1024+ "M");
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/ 1024/1024+ "M");
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/ 1024/1024+ "M");

        byte[] b2 = new byte[4*1024*1024];
        System.out.println("分配了4M");
        System.out.println("max memory:" + Runtime.getRuntime().maxMemory()/ 1024/1024+ "M");
        System.out.println("free memory:" + Runtime.getRuntime().freeMemory()/ 1024/1024+ "M");
        System.out.println("total memory:" + Runtime.getRuntime().totalMemory()/ 1024/1024+ "M");

    }
}
