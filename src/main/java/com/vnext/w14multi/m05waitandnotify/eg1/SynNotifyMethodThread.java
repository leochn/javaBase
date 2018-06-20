package com.vnext.w14multi.m05waitandnotify.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 07:22:11
 */
public class SynNotifyMethodThread extends Thread {

    private Object lock;

    public SynNotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        ThreadService service = new ThreadService();
        service.synNotifyMethod(lock);
    }
}