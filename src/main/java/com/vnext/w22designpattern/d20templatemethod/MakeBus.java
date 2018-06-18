package com.vnext.w22designpattern.d20templatemethod;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:48:33
 */
public class MakeBus extends MakeCar {

    @Override
    public void makeHead() {
        System.out.println("bus:组装车头");
    }

    @Override
    public void makeBody() {
        System.out.println("bus:组装车身");
    }

    @Override
    public void makeTail() {
        System.out.println("bus:组装车尾");
    }
}