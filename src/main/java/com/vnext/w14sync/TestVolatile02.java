package com.vnext.w14sync;

/**
 * volatile关键字能保证可见性没有错，但是下面的程序错在没能保证原子性
 * @author leo
 * @version 2018/2/7 23:15
 * @since 1.0.0
 */
public class TestVolatile02 extends Thread{
    /*volatile 关键字只具有可见性，并没有原子性。要实现原子性建议使用atomic类系列的对象，
    支持原子性操作（注意atomic类只保证本身方法原子性，并不保证多次操作的原子性*/）

    // 1. volatile 并不能保证最终结果的原子性
    private static volatile int count;
    private static void addCount(){
        for (int i = 0; i <1000 ; i++) {
            count++;
        }
        /*1000
        2000
        3000
        4264
        4868
        6213
        6416
        7416
        8416
        9416*/
        System.out.println(count); // System.out.println(); 是系统的一个线程执行的打印，很浪费性能

    }

    // 2. AtomicInteger保证了最终结果的原子性
//    private static AtomicInteger count = new AtomicInteger(0);
//    private static void addCount(){
//        for (int i = 0; i <1000 ; i++) {
//            count.getAndIncrement();
//        }
//        System.out.println(count);
//        /*1000
//        2000
//        3000
//        4000
//        5000
//        6000
//        7611
//        8000
//        9000
//        10000*/
//    }


    public void run(){
        addCount();
    }


    public static void main(String[] args) {
        TestVolatile02[] arr = new TestVolatile02[10];
        for (int i = 0; i < 10 ; i++) {
            arr[i] = new TestVolatile02();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}
