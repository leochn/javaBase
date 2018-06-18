package com.vnext.w22designpattern.d11proxy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:30:42
 */
public class RealSubject implements Subject {

    @Override
    public void sailBook() {
        System.out.println("卖书.....");
    }
}