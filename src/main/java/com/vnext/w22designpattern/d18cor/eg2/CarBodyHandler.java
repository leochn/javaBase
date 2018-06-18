package com.vnext.w22designpattern.d18cor.eg2;


/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:37:50
 */
public class CarBodyHandler extends CarHandler {

    @Override
    public void handlerCar() {
        System.out.println("组装车身");
        if(this.carHandler != null) {
            this.carHandler.handlerCar();
        }
    }
}