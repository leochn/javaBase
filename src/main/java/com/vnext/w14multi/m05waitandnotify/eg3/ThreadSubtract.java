package com.vnext.w14multi.m05waitandnotify.eg3;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 22:05:28
 */
public class ThreadSubtract extends Thread {

    private Subtract r;

    public ThreadSubtract(Subtract r) {
        super();
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}