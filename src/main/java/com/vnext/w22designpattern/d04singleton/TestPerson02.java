package com.vnext.w22designpattern.d04singleton;

/**
 * 多线程测试 饿汉式单列
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:20:46
 */
public class TestPerson02 extends Thread {

    @Override
    public void run() {
        System.out.println(Person02.getInstance().hashCode());
    }

    public static void main(String[] args) {
        TestPerson02[] ts = new TestPerson02[500];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TestPerson02();
        }
        for (int i = 0; i < ts.length; i++) {
            ts[i].start();
        }
    }
}