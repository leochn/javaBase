package com.vnext.w14multi;

/**
 * @author leo
 * @version 2018/2/7 22:18
 * @since 1.0.0
 */
public class TestVolatile01 extends Thread{
    // volatile 概念：volatile关键字的主要作用是使变量在多个线程间可见.
    // volatile的作用就是强制线程到主内存（共享内存）里面去读取变量，
    //   而不去线程工作内存区里读取，从而实现了多个线程间的变量可见，也就是满足线程安全的可见性。

   /* 在java中，每个线程都会有一块工作内存区，其中存放着所有线程共享的主内存中的变量的拷贝；
    当线程执行时，他在自己的工作内存区中操作这些变量。
    为了存取一个共享的变量，一个线程通常先获取锁定并清除他的内存工作区，
    把这些共享变量从所有线程的共享内存区中正确的装入到他自己所在的工作内存区中，
    当线程解锁时保证该工作内存区中变量的值也写回到共享内存中。*/

   /*一个线程可以执行的操作有使用use，赋值assign，装载load，存储store，锁定lock，解锁unlock；
    而主内存可以执行的操作有读read，写write，锁定lock，解锁unlock，每个操作都是原子的。*/

   //private volatile boolean isRuning = true;
   private boolean isRuning = true;
   private void setRuning(boolean isRuning){
       this.isRuning = isRuning;
   }
   public void run(){
       System.out.println("进入run方法...");
       while (isRuning == true){
           // ......
           int i = 1;
           i = 6;
       }
       System.out.println("线程停止...");
   }

    public static void main(String[] args) throws InterruptedException {
        TestVolatile01 tv = new TestVolatile01();
        tv.start();
        Thread.sleep(1000);
        tv.setRuning(false);
        System.out.println("isRuning的值已经设置为false");
        Thread.sleep(1000);
        System.out.println("isRuning=" + tv.isRuning);
    }

}


