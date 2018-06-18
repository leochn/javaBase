package com.vnext.w14multi.m01base;

/**
 * 多个线程多个锁:多个线程，每个线程都可以拿到自己指定的锁，分别获得锁之后，执行 synchronized方法体的内容。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 19:14:00
 */
public class T03MyThread {

    /**
     *  关键字synchronized取得的锁都是对象锁，而不是把一段代码（方法）当做锁，
     *  所以代码中哪个线程先执行synchronized关键字的方法，哪个线程就持有该方法所属对象的锁（Lock），
     *
     *  在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）。
     */

    /** static */
    private static int num = 0;

    /** static */
    public static synchronized void printNum(String tag){
        try {
            if (tag.equals("a")) {
                num = 100;
                System.out.println("tag a, set num over!");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("tag b, set num over!");
            }

            System.out.println("tag " + tag + ", num = " + num);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //注意观察run方法输出顺序
    public static void main(String[] args) {

        /**
         * 打印结果：
         * tag a, set num over!
         * tag a, num = 100
         * tag b, set num over!
         * tag b, num = 200
         *
         * 因为：在静态方法上加synchronized关键字，表示锁定.class类，类一级别的锁（独占.class类）
         */

        //俩个不同的对象
        final T03MyThread m1 = new T03MyThread();
        final T03MyThread m2 = new T03MyThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.printNum("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.printNum("b");
            }
        });

        t1.start();
        t2.start();

    }
}