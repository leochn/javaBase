package com.vnext.w14multi.m02base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * wait方法释放锁，notify方法不释放锁,使用CountDownLatch 线程通信的及时通知
 * @author leo
 * @version 2018/2/8 19:33
 * @since 1.0.0
 */
public class T07ListAdd {
    private volatile static List<String> list = new ArrayList<>();

    public void add(){
        list.add("thread...");
    }
    public int size(){
        return list.size();
    }

    // 1. CountDownLatch 线程通信的及时通知

    public static void main(String[] args) {

        final T07ListAdd testWaitNotify = new T07ListAdd();
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    testWaitNotify.add();
                    System.out.println("当前线程："+ Thread.currentThread().getName() + "添加了一个元素..");
                    try {
                        Thread.sleep(500);
                        if (testWaitNotify.size() == 5){
                            System.out.println("发出通知...");
                            countDownLatch.countDown();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                if (testWaitNotify.size() != 5){
                    System.out.println("t2进入....");
                    try {
                        Thread.sleep(3000);
                        countDownLatch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程" + Thread.currentThread().getName() + "收到通知停止线程..");
                throw new RuntimeException();
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

       /* t2进入....
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        发出通知...
        当前线程：t1添加了一个元素..
        Exception in thread "t2" java.lang.IllegalMonitorStateException
        at java.lang.Object.wait(Native Method)
        at java.lang.Object.wait(Object.java:502)
        at com.vnext.w14multi.TestWaitNotify02$2.run(TestWaitNotify02.java:55)
        at java.lang.Thread.run(Thread.java:748)
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..
        当前线程：t1添加了一个元素..*/
    }

}
