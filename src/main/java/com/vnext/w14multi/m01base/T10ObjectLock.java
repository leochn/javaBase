package com.vnext.w14multi.m01base;

/**
 * 使用synchronized代码块加锁,比较灵活
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 20:55:00
 */
public class T10ObjectLock {

    public void method1(){
        synchronized (this) {	//对象锁
            try {
                System.out.println("do method1..");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void method2(){		//类锁
        synchronized (T10ObjectLock.class) {
            try {
                System.out.println("do method2..");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Object lock = new Object();
    public void method3(){		//任何对象锁
        synchronized (lock) {
            try {
                System.out.println("do method3..");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        final T10ObjectLock objLock = new T10ObjectLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                objLock.method1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                objLock.method2();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                objLock.method3();
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}