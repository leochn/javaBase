package com.vnext.w19juc.juc02;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock : 读写锁
 *
 * @author leo
 * @version 2018/3/26 6:38
 * @since 1.0.0
 */
public class Test04ReadWriteLock {
    /*
     * 1. ReadWriteLock : 读写锁
     *
     * 写写/读写 需要“互斥”
     * 读读 不需要互斥
     *
     */
    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                readWriteLockDemo.set((int) (Math.random() * 101));
            }
        },"write:").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockDemo.get();
                }
            }).start();
        }
    }

}


class ReadWriteLockDemo {
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    // 读
    public void get() {
        lock.readLock().lock();  //上锁

        try {
            System.out.println(Thread.currentThread().getName() + ":" + number);
        } finally {
            lock.readLock().unlock(); //释放锁
        }
    }

    // 写
    public void set(int number) {
        lock.writeLock().lock();
        try {
            this.number = number;
            System.out.println(Thread.currentThread().getName() +",number=" + number);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
