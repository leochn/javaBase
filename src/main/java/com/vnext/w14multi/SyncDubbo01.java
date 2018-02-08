package com.vnext.w14multi;

/**
 * 重入锁
 * @author leo
 * @version 2018/2/7 21:37
 * @since 1.0.0
 */
public class SyncDubbo01 {
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
        final SyncDubbo01 sd = new SyncDubbo01();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });
        t1.start();
    }
}
