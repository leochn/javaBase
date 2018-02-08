package com.vnext.w14multi;

/**
 * @author leo
 * @version 2018/2/9 7:21
 * @since 1.0.0
 */
public class TestAtomic {

    public static int i = 0;

    public static void increase() {
        //这里延迟1毫秒,增加线程切换的随机性,也可以不加
        try {
            Thread.sleep(1);
        } catch (Exception e) {
        }

        i++;
    }

    public static void multiThread(int threadCnt) {
        for (int i = 0; i < threadCnt; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    TestAtomic.increase();
                }
            }).start();
        }
    }

    public static void main(String[] args) {

        int threadCnt = 1000;
        int times = 10;

        System.out.println(threadCnt + "个线程并发计算i++:");
        //运行多次观察不同
        for ( int x = 0; x < times; x++) {
            //初始化变量
            i = 0;
            //同时启动 1000 个线程，并发计算i++
            multiThread(threadCnt);
            System.out.println("运行第 " + (x+1 < 10 ? "0":"") + (x+1) + " 次的结果: i=" + TestAtomic.i);
        }
    }
}

