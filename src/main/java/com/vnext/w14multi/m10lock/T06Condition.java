package com.vnext.w14multi.m10lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 16:14:17
 */
public class T06Condition {
    /**
     * Condition一定是针对具体某一把锁的，也就是在只有锁的基础上才会产生Condition
     */

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1(){
        try {
            lock.lock();
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，进入method1..");
            Thread.sleep(3000);
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，method1 释放锁..");
            condition.await();	// Object wait
            System.out.println("当前线程：" + Thread.currentThread().getName() +"，method1 继续执行...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method2(){
        try {
            lock.lock();
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，进入method2..");
            Thread.sleep(3000);
            System.out.println("当前线程：" + Thread.currentThread().getName() + "，退出method2，发出唤醒..");
            condition.signal();		//Object notify
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

        final T06Condition uc = new T06Condition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method1();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                uc.method2();
            }
        }, "t2");
        t1.start();

        t2.start();
    }
}