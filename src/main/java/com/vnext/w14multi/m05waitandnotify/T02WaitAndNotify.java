package com.vnext.w14multi.m05waitandnotify;

/**
 * wait()、notify 实现线程间通信
 * @author leo
 * @version 1.0.0
 * @date 2018-06-19 21:22:25
 */
public class T02WaitAndNotify {
    /**
     * wait，notify和notifyAll方法是Object类的成员函数，所以Java的任何一个对象都能够调用这三个方法。
     * 这三个方法主要是用于线程间通信，协调多个线程的运行。
     *
     * 1.调用了wait函数的线程会一直等待，直到有其他线程调用了同一个对象的notify或者notifyAll方法才能被唤醒，
     *   需要注意的是：被唤醒并不代表立即获得对象的锁。也就是说，一个线程调用了对象的wait方法后，他需要等待两件事情的发生：
     *     1）有其他线程调用同一个对象的notify或者notifyAll方法（调用notify/notifyAll方法之前）
     *     2）被唤醒之后重新获得对象的锁(调用notify/notifyAll方法之后)
     *   才能继续往下执行后续动作。
     *   如果一个线程调用了某个对象的wait方法，但是后续并没有其他线程调用该对象的notify或者notifyAll方法，则该线程将会永远等下去。
     *
     * 2.notify方法只会唤醒一个正在等待的线程(至于唤醒谁，不确定！)，而notifyAll方法会唤醒所有正在等待的线程。
     *   还有一点需要特别强调：调用notify和notifyAll方法后，当前线程并不会立即放弃锁的持有权，而必须要等待当前同步代码块执行完才会让出锁。
     *   如果一个对象之前没有调用wait方法，那么调用notify方法是没有任何影响的。
     */

    private static final Object lock = new Object();

    public static void main(String[] args) {

        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();

        /**
         * 运行结果如下：
         * Thread1 start...
         * thread2..run...
         * before .. wait()..
         * Thread2 lock start...
         * Thread2 lock stop...
         * Thread2.. stop...
         * after .. wait()..
         * Thread1 stop...
         *
         * 从上面的例子可以证实上面说到的一个结论：
         *     线程调用notify方法后并不会让出锁，而必须等待同步代码块执行完毕之后再让出，
         *     可以看到执行结果中Thread2的开始和结束是成对挨着出现的。
         */

    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread1 start...");
            synchronized (lock) {
                try {
                    System.out.println("before .. wait()..");
                    Thread.sleep(300);
                    lock.wait();
                    System.out.println("after .. wait()..");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread1 stop...");
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            System.out.println("thread2..run...");
            synchronized (lock) {
                System.out.println("Thread2 lock start...");
                lock.notify();
                System.out.println("Thread2 lock stop...");
            }
            System.out.println("Thread2.. stop...");
        }
    }



}