package com.vnext.w14multi.m02base;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 21:17:06
 */
public class T03Atomic extends Thread{


    // volatile 关键字只具有可见性，并没有原子性
    // AtomicInteger保证了最终结果的原子性
    private static AtomicInteger count = new AtomicInteger(0);
    private static void addCount(){
        for (int i = 0; i <1000 ; i++) {
            count.getAndIncrement();
        }
        System.out.println(count);
        /*1000
        2000
        3000
        4000
        5000
        6000
        7611
        8000
        9000
        10000*/
    }


    public void run(){
        addCount();
    }


    public static void main(String[] args) {
        T03Atomic[] arr = new T03Atomic[10];
        for (int i = 0; i < 10 ; i++) {
            arr[i] = new T03Atomic();
        }
        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }
}