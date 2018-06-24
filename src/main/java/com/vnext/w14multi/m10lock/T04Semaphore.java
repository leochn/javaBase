package com.vnext.w14multi.m10lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 15:31:16
 */
public class T04Semaphore {

    /**
     * Semaphore可以控制系统的流量，拿到信号量的线程可以进入，否则就等待，通过acquire()和release()获取和释放访问许可
     */

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 20; index++) {
            final int NO = index;
            Runnable runnable = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing, NO-" + NO);
                    //模拟实际业务逻辑
                    long time = (long) (Math.random() * 10000);
                    System.out.println("NO-" + NO +",需要耗时:"+ time);
                    Thread.sleep(time);
                    System.out.println("Leaveing, NO-" + NO);
                    // 访问完后，释放
                    semp.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(runnable);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(semp.getQueueLength());

        // 退出线程池
        exec.shutdown();
    }
}