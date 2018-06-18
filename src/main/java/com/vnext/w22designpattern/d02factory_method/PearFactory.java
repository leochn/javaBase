package com.vnext.w22designpattern.d02factory_method;

/**
 * 具体工厂（ Concrete  Creator）角色  具体工厂类是抽象工厂的一个实现，负责实例化产品对象。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:56:20
 */
public class PearFactory implements FruitFactory {

    public Fruit getFruit() {
        return new Pear();
    }
}
