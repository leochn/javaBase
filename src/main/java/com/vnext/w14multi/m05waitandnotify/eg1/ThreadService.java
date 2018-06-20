package com.vnext.w14multi.m05waitandnotify.eg1;

/**
 * @version 1.0.0
 */
public class ThreadService {

    public void testMethod(Object lock) {
        try {
            synchronized (lock) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + ",testMethod begin wait");
                lock.wait();
                System.out.println(threadName + ",testMethod end wait");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void synNotifyMethod(Object lock) {
        try {
            synchronized (lock) {
                String threadName = Thread.currentThread().getName();
                long startTime = System.currentTimeMillis();
                System.out.println( threadName + ",synNotifyMethod begin notify");
                lock.notify();
                Thread.sleep(5000);
                long endTime = System.currentTimeMillis();
                System.out.println(threadName + ",synNotifyMethod begin notify; 耗时="+(endTime - startTime));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * 在第8行的testMethod()中调用 wait()，在第17行的synNotifyMethod()中调用notify()
     *
     * 从上面的代码可以看出，wait() 与  notify/notifyAll()都是放在同步代码块中才能够执行的。
     * 如果在执行wait() 与  notify/notifyAll() 之前没有获得相应的对象锁，就会抛出：java.lang.IllegalMonitorStateException异常。
     *
     * 在第13行，当ThreadA线程执行lock.wait();这条语句时，释放获得的对象锁lock，并放弃CPU，进入等待队列。
     *
     * 当 [另一个线程] 执行第26行lock.notify();会唤醒ThreadA,但是此时它并不立即释放锁,接下来它睡眠了5秒钟(sleep()是不释放锁的,事实上sleep()也可以不在同步代码块中调用).
     * 直到第33行，退出synchronized修饰的临界区时，才会把锁释放。
     * 这时，ThreadA就有机会获得 [另一个线程] 释放的锁，并从等待的地方起（第9行）起开始执行。
     *
     *
     *
     *
     */
}
