package com.vnext.w22designpattern.d03abstract_factory;

/**
 * 具体工厂（ Concrete  Creator）角色: 具体工厂类是抽象工厂的一个实现，负责实例化某个产品族中的产品对象。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 08:34:41
 */
public class NorthFruitFactory implements FruitFactory {

    public Fruit getApple() {
        return new NorthApple();
    }

    public Fruit getBanana() {
        return new NorthBanana();
    }

}