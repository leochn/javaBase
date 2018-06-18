package com.vnext.w22designpattern.d02factory_method;

/**
 * 抽象工厂（Creator）角色: 工厂方法模式的核心，任何工厂类都必须实现这个接口。
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:33:34
 */
public interface FruitFactory {

    public Fruit getFruit();

}