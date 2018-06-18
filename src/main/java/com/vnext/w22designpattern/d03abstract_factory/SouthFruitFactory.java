package com.vnext.w22designpattern.d03abstract_factory;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 08:35:32
 */
public class SouthFruitFactory implements FruitFactory {

    public Fruit getApple() {
        return new SouthApple();
    }

    public Fruit getBanana() {
        return new SouthBanana();
    }

}