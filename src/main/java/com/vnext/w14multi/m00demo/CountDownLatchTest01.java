package com.vnext.w14multi.m00demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: LEO
 * @Date: 2019/2/5 08:46
 * @Description:
 */
public class CountDownLatchTest01 {

    private static final int THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {

        // 当分配的7个人（7个线程）分别找到龙珠之后，也就是所有的线程执行完毕，
        // 才可以召唤龙珠（执行countDownLatch.await()之后的代码）。
        //注意：
        //（1）CountDownLatch的构造函数:CountDownLatch countDownLatch = new CountDownLatch(7);
        //     7表示需要等待执行完毕的线程数量。
        //（2）在每一个线程执行完毕之后，都需要执行countDownLatch.countDown()方法，不然计数器就不会准确；
        //（3）只有所有的线程执行完毕之后，才会执行 countDownLatch.await()之后的代码；
        //（4）可以看出上述代码中CountDownLatch 阻塞的是主线程；

        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("第" + index + "颗龙珠已收集到！");
                    //模拟收集第i个龙珠,随机模拟不同的寻找时间
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //每收集到一颗龙珠,需要等待的颗数减1
                countDownLatch.countDown();
            }).start();
        }
        //等待检查，即上述7个线程执行完毕之后，执行await后边的代码
        countDownLatch.await();
        System.out.println("集齐七颗龙珠！召唤神龙！");

//        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
//            int index = i;
//            new Thread(() -> {
//                try {
//                    System.out.println("第" + index + "颗龙珠已收集到！");
//                    //模拟收集第i个龙珠,随机模拟不同的寻找时间
//                    //Thread.sleep(Thread.sleep(Math.abs(new Random().nextInt(3000))));
//                    Thread.sleep(new Random().nextInt(3000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }
//        System.out.println("集齐七颗龙珠！召唤神龙！");

    }

}
