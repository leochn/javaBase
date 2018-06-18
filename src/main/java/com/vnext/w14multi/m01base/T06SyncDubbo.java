package com.vnext.w14multi.m01base;

/**
 * 重入锁:synchronized 锁重入
 * @author leo
 * @version 2018/2/7 21:37
 * @since 1.0.0
 */
public class T06SyncDubbo {

    public synchronized void method1(){
        System.out.println("method1");
        method2();
    }

    // 上面便是synchronized的重入锁特性，即调用method1()方法时，已经获得了锁，
    //   此时内部调用method2()方法时，由于本身已经具有该锁，所以可以再次获取
    private synchronized void method2() {
        System.out.println("method2");
        method3();
    }

    private synchronized void method3() {
        System.out.println("method3");
    }

    public static void main(String[] args) {

        /**
         * 即在使用synchronized时，当一个线程得到一个对象锁后，再次请求此对象锁时，是可以再次得到该对象的锁的。
         * 也就是说在一个synchronized方法或块的内部调用本类的其他synchronized方法或块时，是永远可以得到锁的。
         */

        final T06SyncDubbo sd = new T06SyncDubbo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });
        t1.start();
    }
}
