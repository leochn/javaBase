package com.vnext.w14multi.m01base;

/**
 * 锁对象的改变问题
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 20:59:23
 */
public class T12ChangeLock {

    private String lock = "lock";

    private void method(){
        synchronized (lock) {
            try {
                System.out.println("当前线程 : "  + Thread.currentThread().getName() + "开始");
                lock = "change lock";  // 修改lock字符后，锁就发生了变化,其他线程就可以进来了.
                Thread.sleep(2000);
                System.out.println("当前线程 : "  + Thread.currentThread().getName() + "结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final T12ChangeLock changeLock = new T12ChangeLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        },"t2");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}