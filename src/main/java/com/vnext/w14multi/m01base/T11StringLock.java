package com.vnext.w14multi.m01base;

/**
 * synchronized代码块对字符串的锁，注意String常量池的缓存功能
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 20:57:15
 */
public class T11StringLock {

    public void method() {

        synchronized (new String("字符串常量")) {
        //synchronized ("字符串常量") {
            try {
                while(true){
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final T11StringLock stringLock = new T11StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}