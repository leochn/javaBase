package com.vnext.w14multi.m05waitandnotify.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 07:20:49
 */
public class ThreadA extends Thread {

    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        ThreadService service = new ThreadService();
        service.testMethod(lock);
    }
}