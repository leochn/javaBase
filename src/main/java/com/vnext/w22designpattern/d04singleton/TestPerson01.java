package com.vnext.w22designpattern.d04singleton;


/**
 * 多线程测试 懒汉式单列
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 09:11:39
 */
public class TestPerson01 extends Thread{

    @Override
    public void run() {
        //System.out.println(Person01.getInstance01().hashCode());
        System.out.println(Person01.getInstance().hashCode());
    }

    public static void main(String[] args) {
        TestPerson01[] ts = new TestPerson01[500];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new TestPerson01();
        }
        for (int i = 0; i < ts.length; i++) {
            ts[i].start();
        }
    }
}