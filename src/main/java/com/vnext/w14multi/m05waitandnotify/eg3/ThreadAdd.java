package com.vnext.w14multi.m05waitandnotify.eg3;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 22:03:21
 */
public class ThreadAdd extends Thread {

    private Add p;

    public ThreadAdd(Add p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}