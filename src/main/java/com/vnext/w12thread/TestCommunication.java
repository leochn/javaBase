package com.vnext.w12thread;

/**
 * 线程唤醒
 *
 * @author leo
 * @since 2018/2/8 9:30
 */
public class TestCommunication {


    /**
     * 线程通信。如下的三个关键字使用的话，都得在同步代码块或同步方法中。
     * 1.wait():   一旦一个线程执行到wait()，就释放当前的锁。
     * 2.notify(): 唤醒wait的一个线程
     * 3.notifyAll():唤醒wait的所有线程
     *
     * wait(),notify(),notifyAll()这三个方法只有在synchronized方法或synchronized代码块中才能使用，
     *     否则会java.lang.illegalMonitorStateExecption异常
     */


    public static void main(String[] args) {

        // 测试：使用两个线程打印 1-100. 线程1, 线程2 交替打印
        PrintNum p = new PrintNum();
        Thread t1 = new Thread(p, "AAA");
        Thread t2 = new Thread(p, "BBB");
        t1.start();
        t2.start();

    }
}


// 测试：使用两个线程打印 1-100. 线程1, 线程2 交替打印
class PrintNum implements Runnable {

    private int num = 1;
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                object.notify();
                if (num <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ",num=" + num);
                    num++;
                } else {
                    break;
                }
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
