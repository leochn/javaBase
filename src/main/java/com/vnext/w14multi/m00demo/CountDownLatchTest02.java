package com.vnext.w14multi.m00demo;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * countDownLatch.await(long, TimeUnit);等待超时,
 * 针对某些业务场景，如果某一个线程的操作耗时非常长或者发生了异常;
 * 但是并不想影响主线程的继续执行, 则可以使用await(long, TimeUnit)方法.
 * 即一个线程(或者多个线程)，等待另外n个线程执行long时间后继续执行.
 *
 * 多线程join和countDownLatch.await()区别:
 * 调用thread.join()方法必须等thread执行完毕,当前线程才能继续往下执行;
 * 而CountDownLatch通过计数器提供了更灵活的控制，只要检测到计数器为0当前线程就可以往下执行而不用管相应的thread是否执行完毕。
 *
 * @Auther: LEO
 * @Date: 2019/2/6 07:47
 * @Description:
 */
public class CountDownLatchTest02 {


    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Test1T21(countDownLatch).start();
        new Test1T22(countDownLatch).start();
        new Test1T23(countDownLatch).start();
        try {
            // 如果countDownLantch计数器为不为0,则会在这里等待4000毫秒...
            // 如果countDownLantch计数器=0,这里就不再等待了...
            countDownLatch.await(4000, TimeUnit.MILLISECONDS);
            // 继续执行下面的逻辑...(略)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Success...");
        System.out.println("主线程耗时==" + (System.currentTimeMillis()-l));
    }
}

class Test1T21 extends Thread {

    private CountDownLatch cdl;

    Test1T21(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + "Test1T21-name =" + Thread.currentThread().getName());
        cdl.countDown();
    }
}

class Test1T22 extends Thread {

    private CountDownLatch cdl;

    Test1T22(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + "Test1T22-name =" + Thread.currentThread().getName());
        cdl.countDown();
    }
}

class Test1T23 extends Thread {

    private CountDownLatch cdl;

    Test1T23(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    public void run() {
        //cdl.countDown();
        try {
            // 这个线程耗时 5000 毫秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date() + "Test1T23-name =" + Thread.currentThread().getName());
        cdl.countDown();
    }
}

