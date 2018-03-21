package com.vnext.w19juc.juc01;

/**
 * @author leo
 * @version 2018/3/22 7:10
 * @since 1.0.0
 */
public class Test01Volatile {
    /*
     * 一、volatile 关键字：当多个线程进行操作共享数据时，可以保证内存中的数据可见。
     * 					  相较于 synchronized 是一种较为轻量级的同步策略。
     *
     * 注意：
     * 1. volatile 不具备"互斥性"
     * 2. volatile 不能保证变量的"原子性"
     */

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td).start();

        while(true){
            if(td.isFlag()){
                System.out.println("------------------");
                break;
            }
        }

    }

}


class ThreadDemo implements Runnable {

    private volatile boolean flag = false;

    //private boolean flag = false;
    // 如果不加volatile关键字，main线程永远无法进入while中的if里面
    // 原因:

    @Override
    public void run() {

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }

        flag = true;

        System.out.println("flag=" + isFlag());

    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

}
