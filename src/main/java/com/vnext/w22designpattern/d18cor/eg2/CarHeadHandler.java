package com.vnext.w22designpattern.d18cor.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:33:47
 */
public class CarHeadHandler extends CarHandler {

    @Override
    public void handlerCar() {
        System.out.println("组装车头");
        if(this.carHandler != null) {
            this.carHandler.handlerCar();
        }
    }
}