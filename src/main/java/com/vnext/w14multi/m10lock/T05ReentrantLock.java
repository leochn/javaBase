package com.vnext.w14multi.m10lock;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 15:49:44
 */
public class T05ReentrantLock {

    /**
     * ReentrantLock,重入锁
     * 在需要进行同步的代码部分加上锁定，但不要忘记最后一定要释放锁定，不然会造成锁永久无法释放，其他线程永远进不来的结果.
     */

    private Lock lock = new ReentrantLock();
    //private Lock lock = new ReentrantLock(false); // 公平锁和非公平锁，false公平锁

    /**
     * lock用法：
     * tryLock():尝试获得锁，获得结果用true/false返回。
     * tryLock():在给定的时间内尝试获得锁，获得结果用true/false返回。
     * ifFair():是否是公平锁。
     * isLocked():是否锁定
     * getHoldCount():查询当前线程保持此锁的个数，也就是调用lock()次数。
     * lockInterruptibly():优化响应中断的锁。
     * getQueueLength():返回正在等待获取此锁定的线程数。
     *
     */

    public void method1(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1..");
            Thread.sleep(1000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1..");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2..");
            Thread.sleep(2000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2..");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final T05ReentrantLock ur = new T05ReentrantLock();

        Thread t1 = new Thread(()->{
            ur.method1();
            ur.method2();
        }, "t1");

        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(ur.lock.getQueueLength());
    }

}