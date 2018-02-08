package com.vnext.w14multi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @version 2018/2/8 19:33
 * @since 1.0.0
 */
public class TestWaitNotify01 {
    private volatile static List<String> list = new ArrayList<>();

    public void add(){
        list.add("thread...");
    }
    public int size(){
        return list.size();
    }





    // 1. wait方法释放锁，notify方法不释放锁
    public static void main(String[] args) {
        final TestWaitNotify01 testWaitNotify = new TestWaitNotify01();
        // 实例化一个lock
        final Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i < 10; i++) {
                        testWaitNotify.add();
                        System.out.println("当前线程："+ Thread.currentThread().getName() + "添加了一个元素..");
                        try {
                            Thread.sleep(500);
                            if (testWaitNotify.size() == 5){
                                System.out.println("发出通知...");
                                lock.notify();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    if (testWaitNotify.size() != 5){
                        System.out.println("t2进入....");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程" + Thread.currentThread().getName() + "收到通知停止线程..");
                    throw new RuntimeException();
                }
            }
        },"t2");

        t2.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();


        // 打印结果如下：
        // 问题：为什么发出通知后，t2并没有马上抛出异常，t1继续添加元素呢？（因为notify方法不释放锁）

        /*t2进入....
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        发出通知...
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程t2收到通知停止线程..
        Exception in thread "t2" java.lang.RuntimeException
        at com.vnext.w14multi.TestWaitNotify01$2.run(TestWaitNotify01.java:64)
        at java.lang.Thread.run(Thread.java:748)*/
    }

}
