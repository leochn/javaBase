package com.vnext.w14multi.m00demo;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: LEO
 * @Date: 2019/1/16 08:05
 * @Description:
 */
public class A01DemoTest {

    public static void main(String[] args) throws InterruptedException {

//        // 1.
//        // 主线程启动十个子线程，所有的子线程都执行完成之后，再去执行主线程，请写出执行代码
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        ThreadProvider[] threadProviders = new ThreadProvider[10];
//        for (int i = 0; i < 10; i++) {
//            threadProviders[i] = new ThreadProvider(countDownLatch,"Thread" + (i+1));
//        }
//        for (ThreadProvider threadProvider : threadProviders) {
//            executorService.execute(threadProvider);
//        }
//        countDownLatch.wait();
//        System.out.println("|----------子线程都执行完成了,主线程开始执行................");


        // 2.
        System.out.println("主线程开始................");
        long startTime = System.currentTimeMillis();
        int threadNum = 5; //线程数
        //定义正在运行的线程数
        CountDownLatch runningThreadNum = new CountDownLatch(threadNum);
        System.out.println(Thread.currentThread().getName() + "-start......");
        //创建多个子线程
        for (int i = 0; i < threadNum; i++) {
            new SubThread(runningThreadNum).start();
        }
        //等待子线程都执行完了再执行主线程剩下的动作
        runningThreadNum.await();
        System.out.println(Thread.currentThread().getName() + "-end..........");
        long endTime = System.currentTimeMillis();
        System.out.println("子线程都执行完成了,总耗时:" + (endTime - startTime) + "主线程继续往下执行...:");


    }
}
