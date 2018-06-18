package com.vnext.w22designpattern.d07decorator;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:11:22
 */
public class RunCar implements Car {

    public void run() {
        System.out.println("可以跑");
    }

    public void show() {
        this.run();
    }

}