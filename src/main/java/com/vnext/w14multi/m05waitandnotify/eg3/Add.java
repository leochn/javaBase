package com.vnext.w14multi.m05waitandnotify.eg3;

/**
 * Add类，负责添加数据
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 22:02:57
 */
public class Add {

    private String lock;
    public Add(String lock) {
        super();
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyString");
            lock.notifyAll();
        }
    }
}