package com.vnext.w22designpattern.d07decorator;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:11:54
 */
public abstract class CarDecorator implements Car{
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public CarDecorator(Car car) {
        this.car = car;
    }

    public abstract void show();
}