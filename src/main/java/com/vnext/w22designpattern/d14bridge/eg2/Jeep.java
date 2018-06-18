package com.vnext.w22designpattern.d14bridge.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:03:24
 */
public class Jeep extends Car {

    public Jeep(Engine engine) {
        super(engine);
    }

    @Override
    public void installEngine() {
        System.out.print("Jeep");
        this.getEngine().installEngine();
    }
}