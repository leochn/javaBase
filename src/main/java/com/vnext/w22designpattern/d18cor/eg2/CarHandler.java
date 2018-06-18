package com.vnext.w22designpattern.d18cor.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:33:15
 */
public abstract class CarHandler {

    protected CarHandler carHandler;

    public CarHandler setNextHandler(CarHandler carHandler) {
        this.carHandler = carHandler;
        return this.carHandler;
    }

    public abstract void handlerCar();
}