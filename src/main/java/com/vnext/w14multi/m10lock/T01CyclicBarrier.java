package com.vnext.w14multi.m10lock;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.*;

/**
 * CyclicBarrier
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 13:20:45
 */
public class T01CyclicBarrier {

    /**
     * 假设场景：每一个线程代表一个跑步运动员，当运动员都准备好之后，才一起出发，只要有一个人没有准备好，大家都等待。
     */

    static class Runner implements Runnable {
        private CyclicBarrier barrier;
        private String name;

        public Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }
        @Override
        public void run() {
            try {
                Thread.sleep(1000 * (new Random()).nextInt(5));
                System.out.println(name + " 准备OK.");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + " Go!!");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);  // 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(new Thread(new Runner(barrier, "zhangsan")));
        executor.submit(new Thread(new Runner(barrier, "lisi")));
        executor.submit(new Thread(new Runner(barrier, "wangwu")));

        executor.shutdown();
    }
}