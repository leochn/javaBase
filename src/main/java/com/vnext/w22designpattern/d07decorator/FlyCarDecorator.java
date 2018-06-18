package com.vnext.w22designpattern.d07decorator;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:12:20
 */
public class FlyCarDecorator extends CarDecorator{

    public FlyCarDecorator(Car car) {
        super(car);
    }

    public void show() {
        this.getCar().show();
        this.fly();
    }

    public void fly() {
        System.out.println("可以飞");
    }

    public void run() {

    }
}