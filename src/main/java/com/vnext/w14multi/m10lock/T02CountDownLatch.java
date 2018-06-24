package com.vnext.w14multi.m10lock;

import java.util.concurrent.CountDownLatch;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 13:24:39
 */
public class T02CountDownLatch {

    /**
     * CountDownLatch:经常用于监听某些初始化操作，等初始化执行完毕后，通知主线程继续工作
     */

    public static void main(String[] args) {

        // new CountDownLatch(2)：这里值为2，所以 countDown.await() 只要等到 2个countDown.countDown()，就会往下执行.
        final CountDownLatch countDown = new CountDownLatch(2);
        //final CountDownLatch countDown = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("进入线程t1" + "等待其他线程处理完成...");
                    countDown.await();
                    System.out.println("t1线程继续执行...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t2线程进行初始化操作...");
                    Thread.sleep(3000);
                    System.out.println("t2线程初始化完毕，通知t1线程继续...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("t3线程进行初始化操作...");
                    Thread.sleep(6000);
                    System.out.println("t3线程初始化完毕，通知t1线程继续...");
                    countDown.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}