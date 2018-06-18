package com.vnext.w19juc.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟高并发，发现系统中潜在的线程安全问题：
 * 采用Semaphore(信号量)，CountDownLatch(闭锁)，ExecutorService(线程池)进行模拟.
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 07:34:45
 */
public class Test01Count {

    // 请求总是
    private static int clientTotal = 5000;
    // 同时并发执行的线程数
    private static int threadTotal = 200;

    //private static int count = 0;
    // AtomicInteger 原子操作
    private static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newCachedThreadPool();
        // 信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 闭锁减一
                countDownLatch.countDown();
            });
        }

        // 线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count=" + count);

    }

//    // 这里add是非线程安全的,导致每次执行的结果不一致
//    private static void add (){
//        count++;
//    }

    // 改造 add 为线程安全
    private static void add (){
        count.incrementAndGet();
    }

}