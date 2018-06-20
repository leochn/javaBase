package com.vnext.w14multi.m05waitandnotify.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 07:23:01
 */
public class Test01 {

    public static void main(String[] args) {

        Object lock = new Object();

        ThreadA a = new ThreadA(lock);
        a.start();

        SynNotifyMethodThread c = new SynNotifyMethodThread(lock);
        c.start();
    }
}