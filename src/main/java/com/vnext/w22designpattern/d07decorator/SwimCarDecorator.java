package com.vnext.w22designpattern.d07decorator;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:12:37
 */
public class SwimCarDecorator extends CarDecorator {

    public SwimCarDecorator(Car car) {
        super(car);
    }

    public void show() {
        this.getCar().show();
        this.swim();
    }

    public void swim() {
        System.out.println("可以游");
    }

    public void run() {

    }

}