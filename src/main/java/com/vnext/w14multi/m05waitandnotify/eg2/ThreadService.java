package com.vnext.w14multi.m05waitandnotify.eg2;

/**
 * @version 1.0.0
 */
public class ThreadService {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                int i = 0;
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ",testMethod begin wait");
                lock.wait();
                System.out.println(threadName + ",testMethod end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("出现异常");
        }
    }

}
