package com.vnext.w22designpattern.d03abstract_factory;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 08:35:54
 */
public class Test {

    /**
     * 抽象工厂模式:是所有形态的工厂模式中最为抽象和最其一般性的。
     * 抽象工厂模式可以向客户端提供一个接口，使得客户端在不必指定产品的具体类型的情况下，能够创建多个产品族的产品对象。
     */

    public static void main(String[] args) {

        FruitFactory ff = new NorthFruitFactory();
        // 具体产品（Concrete Product）角色: 抽象模式所创建的具体实例对象
        Fruit apple = ff.getApple();
        apple.get();

        Fruit banana = ff.getBanana();
        banana.get();

        FruitFactory ff2= new SouthFruitFactory();
        Fruit apple2 = ff2.getApple();
        apple2.get();

        Fruit banana2 = ff2.getBanana();
        banana2.get();
    }
}