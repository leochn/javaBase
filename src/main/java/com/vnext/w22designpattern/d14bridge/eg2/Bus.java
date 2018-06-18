package com.vnext.w22designpattern.d14bridge.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:01:23
 */
public class Bus extends Car {

    public Bus(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Bus");
        this.getEngine().installEngine();
    }

}