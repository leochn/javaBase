package com.vnext.w14multi.m02base;

/**
 * ThreadLocal:线程局部变量，是一种多线程间并发访问变量的解决方案。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 22:00:23
 */
public class T10ConnThreadLocal {

    public static ThreadLocal<String> th = new ThreadLocal<String>();

    public void setTh(String value){
        th.set(value);
    }
    public void getTh(){
        System.out.println(Thread.currentThread().getName() + ":" + this.th.get());
    }

    public static void main(String[] args) throws InterruptedException {

        final T10ConnThreadLocal ct = new T10ConnThreadLocal();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ct.setTh("张三");
                ct.getTh();
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    ct.getTh();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}