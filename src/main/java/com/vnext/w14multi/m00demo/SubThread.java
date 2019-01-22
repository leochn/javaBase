package com.vnext.w14multi.m00demo;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: LEO
 * @Date: 2019/1/16 08:27
 * @Description:
 */
public class SubThread extends Thread{


    //子线程记数器,记载着运行的线程数

    private CountDownLatch runningThreadNum;


    public SubThread(CountDownLatch runningThreadNum){

        this.runningThreadNum = runningThreadNum;

    }



    @Override

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-start");
        System.out.println(Thread.currentThread().getName()+"-do something");
        System.out.println(Thread.currentThread().getName()+"-end");
        runningThreadNum.countDown();//正在运行的线程数减一

    }
}
