package com.vnext.w14multi.m08ThreadPoolExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @version 2018/2/13 6:56
 * @since 1.0.0
 */
public class UseThreadPoolExecutor2 implements Runnable{

    private static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        int temp = count.incrementAndGet();
        System.out.println("任务" + temp);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();

        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                10,
                120L,
                TimeUnit.SECONDS,
                queue);
        for (int i = 0; i < 20; i++) {
            executorService.execute(new UseThreadPoolExecutor2());
        }

        Thread.sleep(1000);
        System.out.println("queue size:" + queue.size());
        Thread.sleep(2000);
    }
}
