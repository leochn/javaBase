package com.vnext.w14multi.m05waitandnotify.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 07:36:04
 */
public class Test02 {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();

        Thread.sleep(2000);

        ThreadA a = new ThreadA(lock);
        a.start();

    }

}