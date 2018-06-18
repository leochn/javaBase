package com.vnext.w22designpattern.d18cor.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 11:38:27
 */
public class CarTailHandler extends CarHandler {

    @Override
    public void handlerCar() {
        System.out.println("组装车尾");
        if(this.carHandler != null) {
            this.carHandler.handlerCar();
        }
    }
}