package com.vnext.w22designpattern.d04singleton;

import com.vnext.w12thread.Singleton;

/**
 * 单例模式-懒汉式单例
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:03:49
 */
public class Person01 {

    //关于懒汉式的线程安全问题：使用同步机制
    //对于一般的方法内，使用同步代码块，可以考虑使用this。
    //对于静态方法而言，使用当前类本身充当锁。


    public Person01() {

    }

    private static Person01 instance = null;

    // 线程安全
    public static Person01 getInstance() {
        if (instance == null) {
            synchronized (Person01.class) {
                try {
                    // 懒汉式
                    if (instance == null) {
                        //创建实例之前可能会有一些准备性的耗时工作
                        Thread.sleep(300);
                        instance = new Person01();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    // 线程不安全
    public static Person01 getInstance01() {
        if (instance == null) {
            try {
                // 懒汉式
                if (instance == null) {
                    //创建实例之前可能会有一些准备性的耗时工作
                    Thread.sleep(300);
                    instance = new Person01();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}