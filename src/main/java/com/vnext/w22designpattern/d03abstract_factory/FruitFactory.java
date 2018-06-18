package com.vnext.w22designpattern.d03abstract_factory;

/**
 * 抽象工厂（Creator）角色 : 抽象工厂模式的核心，包含对多个产品结构的声明，任何工厂类都必须实现这个接口。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 08:33:47
 */
public interface FruitFactory {
    //实例化Apple
    public Fruit getApple();
    //实例化Banana
    public Fruit getBanana();
}
