package com.vnext.w14multi.m00demo;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: LEO
 * @Date: 2019/1/16 08:12
 * @Description:
 */
public class ThreadProvider extends Thread {
    CountDownLatch countDownLatch = null;
    String threadName = null;

    public ThreadProvider(CountDownLatch countDownLatch, String threadName) {
        this.countDownLatch = countDownLatch;
        this.threadName = threadName;
    }

    @Override
    public void run(){
        try {
            Thread.currentThread().setName(threadName);
            System.out.println("ThreadName = " + threadName + "========== done ..........");
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != countDownLatch){
                countDownLatch.countDown();
            }
        }

    }

}
