package com.vnext.w14multi.m02base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 21:17:06
 */
public class T04Atomic {

    private static AtomicInteger count = new AtomicInteger(0);

    //多个addAndGet在一个方法内是非原子性的，需要加synchronized进行修饰，保证4个addAndGet整体原子性

    /**
     * synchronized
     */
    public synchronized int multiAdd() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.addAndGet(1);
        count.addAndGet(2);
        count.addAndGet(3);
        count.addAndGet(4); //+10
        return count.get();
    }


    public static void main(String[] args) {

        final T04Atomic au = new T04Atomic();

        List<Thread> ts = new ArrayList<Thread>();
        for (int i = 0; i < 100; i++) {
            ts.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(au.multiAdd());
                }
            }));
        }

        for (Thread t : ts) {
            t.start();
        }


    }

}