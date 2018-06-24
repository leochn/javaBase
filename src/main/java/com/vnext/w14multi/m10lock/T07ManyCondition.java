package com.vnext.w14multi.m10lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-23 16:20:44
 */
public class T07ManyCondition {
    /**
     * 多Condition：
     * 我们可以通过一个Lock对象产生多个Condition进行多线程间的交互，非常灵活。
     * 可以使地部分需要唤醒的线程唤醒，其他线程则继续等待通知。
     */

    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void m1(){
        try {
            lock.lock();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m1等待..");
            c1.await();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m1继续..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m2(){
        try {
            lock.lock();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m2等待..");
            c1.await();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m2继续..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m3(){
        try {
            lock.lock();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "进入方法m3等待..");
            c2.await();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "方法m3继续..");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m4(){
        try {
            lock.lock();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "唤醒..");
            c1.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m5(){
        try {
            lock.lock();
            System.out.println("当前线程：" +Thread.currentThread().getName() + "唤醒..");
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {


        final T07ManyCondition umc = new T07ManyCondition();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                umc.m1();
            }
        },"t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                umc.m2();
            }
        },"t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                umc.m3();
            }
        },"t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                umc.m4();
            }
        },"t4");
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                umc.m5();
            }
        },"t5");

        t1.start();	// c1
        t2.start();	// c1
        t3.start();	// c2


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t4.start();	// c1
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t5.start();	// c2

    }

}