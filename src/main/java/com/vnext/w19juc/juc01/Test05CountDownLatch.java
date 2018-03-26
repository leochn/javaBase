package com.vnext.w19juc.juc01;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * @author leo
 * @version 2018/3/24 15:38
 * @since 1.0.0
 */
public class Test05CountDownLatch {
    /*
     * CountDownLatch ：闭锁，在完成某些运算是，只有其他所有线程的运算全部完成，当前运算才继续执行
     */

    // 计算所有线程执行完成耗费的时间
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(50);
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 50; i++) {
            new Thread(ld).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
        }

        long end = System.currentTimeMillis();

        System.out.println("耗费时间为：" + (end - start));
    }

}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            // 打印 500 以内的偶数
            for (int i = 0; i < 500; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            latch.countDown();
        }

    }

}
