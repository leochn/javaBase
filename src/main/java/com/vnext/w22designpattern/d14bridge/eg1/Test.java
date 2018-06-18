package com.vnext.w22designpattern.d14bridge.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 09:49:01
 */
public class Test {

    public static void main(String[] args) {
        Car car1 = new Bus();
        car1.install2000Engine();
    }

}