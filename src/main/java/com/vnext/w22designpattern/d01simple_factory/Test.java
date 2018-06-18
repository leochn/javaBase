package com.vnext.w22designpattern.d01simple_factory;

/**
 * 简单工厂模式
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:31:48
 */
public class Test {

    /**
     *
     * 1.工厂（Creator）角色  简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象。
     * 2.抽象（Product）角色 简单工厂模式所创建的所有对象的父类，它负责描述所有实例所共有的公共接口。
     * 3.具体产品（Concrete Product）角色 简单工厂模式所创建的具体实例对象
     *
     * 4.简单工厂缺点：
     * 具体产品类不断增多时，可能会出现要求工厂类也要做相应的修改，扩展性并不很好。
     */



    public static void main(String[] args) throws Exception {
        /**
         * 简单工厂模式属于类的创建型模式,又叫做静态工厂方法模式。
         * 通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
         */


      // 1. 直接new对象
      //实例化一个Apple
		Apple apple1 = new Apple();
		//实例化一个Banana
		Banana banana1 = new Banana();
		apple1.get();
		banana1.get();

		// 2.实例化一个Apple,用到了多态
		Fruit apple2 = new Apple();
		Fruit banana2 = new Banana();
		apple2.get();
		banana2.get();


		// 3. 实例化一个Apple，工厂模式
		Fruit apple3 = FruitFactory.getApple();
		Fruit banana3 = FruitFactory.getBanana();
		apple3.get();
		banana3.get();

		// 4.
        Fruit apple4 = FruitFactory.getFruit("apple");
        Fruit banana4 = FruitFactory.getFruit("banana");
        apple4.get();
        banana4.get();

        // 5.
        Fruit apple5 = FruitFactory.getFruitForName("com.vnext.w22designpattern.d01simple_factory.Apple");
        Fruit banana5 = FruitFactory.getFruitForName("com.vnext.w22designpattern.d01simple_factory.Banana");
        apple5.get();
        banana5.get();







    }

}