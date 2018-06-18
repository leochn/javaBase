package com.vnext.w22designpattern.d20templatemethod;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:49:18
 */
public class MakeJeep extends MakeCar {

    @Override
    public void makeHead() {
        System.out.println("jeep:组装车头");
    }

    @Override
    public void makeBody() {
        System.out.println("jeep:组装车身");
    }

    @Override
    public void makeTail() {
        System.out.println("jeep:组装车尾");
    }
}