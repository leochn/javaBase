package com.vnext.w14multi.m10lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 16:25:59
 */
public class T09ReentrantReadWriteLock {
    /**
     * ReentrantReadWriteLock:
     * 1.读写锁ReentrantReadWriteLock，其核心就是实现读写分离的锁，在高并发访问下，尤其读多写少的情况下，性能要远高于重入锁。
     * 2.之前synchronized，ReentrantLock，在同一时间内，只能有一个线程进行访问被锁定的代码。
     *    那么读写锁则不同，其本质是分成两个锁，即读锁、写锁。在读锁下，多线程可以并发的进行访问，但是在写锁的时候，只能一个一个的顺序访问。
     */

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void read(){
        try {
            readLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("当前线程:" + name + ", 进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + name + ", 退出...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    public void write(){
        try {
            writeLock.lock();
            String name = Thread.currentThread().getName();
            System.out.println("当前线程:" + name + ",进入...");
            Thread.sleep(3000);
            System.out.println("当前线程:" + name + ",退出...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {

        final T09ReentrantReadWriteLock urrw = new T09ReentrantReadWriteLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t4");

//      // 1.
//		t1.start();
//		t2.start();

//		// 2.
//      t1.start();
//		t2.start();
//      t3.start();

        // 3.
		t1.start();
		t2.start();
        t3.start();
        t4.start();










    }
}