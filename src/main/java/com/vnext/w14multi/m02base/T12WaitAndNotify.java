package com.vnext.w14multi.m02base;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-19 21:22:25
 */
public class T12WaitAndNotify {
    /**
     * 1.wait()、notify/notifyAll() 方法是Object的本地final方法，无法被重写
     * 2.wait()使当前线程阻塞，前提是 必须先获得锁，一般配合synchronized 关键字使用.
     *     即，一般在synchronized 同步代码块里使用 wait()、notify/notifyAll() 方法。
     * 3.由于 wait()、notify/notifyAll() 在synchronized 代码块执行，说明当前线程一定是获取了锁的。
     *     1).当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态。
     *     2).只有当 notify/notifyAll() 被执行时候，才会唤醒一个或多个正处于等待状态的线程，然后继续往下执行，
     *     直到执行完synchronized 代码块的代码或是中途遇到wait() ，再次释放锁。
     *     3).也就是说，notify/notifyAll() 的执行只是唤醒沉睡的线程，而不会立即释放锁，锁的释放要看代码块的具体执行情况。
     *     所以在编程中，尽量在使用了notify/notifyAll() 后立即退出临界区，以唤醒其他线程
     * 4.wait() 需要被try catch包围，中断也可以使wait等待的线程唤醒。
     * 5.notify 和wait 的顺序不能错，如果A线程先执行notify方法，B线程在执行wait方法，那么B线程是无法被唤醒的
     */

    public static void main(String[] args) {

        // 测试：使用两个线程打印 1-100. 线程1, 线程2 交替打印
        PrintData p = new PrintData();
        Thread t1 = new Thread(p, "线程A");
        Thread t2 = new Thread(p, "线程BB");
        t1.start();
        t2.start();

    }



    // 测试：使用两个线程打印 1-100. 线程1, 线程2 交替打印
    static class PrintData implements Runnable {

        private int data = 1;
        Object object = new Object();

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    object.notify();  // 唤醒一个正处于等待状态的线程,只是唤醒沉睡的线程,而不会立即释放锁
                    if (data <= 100) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ",data=" + data);
                        data++;
                    } else {
                        break;
                    }
                    try {
                        object.wait(); // 当线程执行wait()方法时候，会释放当前的锁，然后让出CPU，进入等待状态.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}