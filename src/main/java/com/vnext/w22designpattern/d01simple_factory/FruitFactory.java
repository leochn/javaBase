package com.vnext.w22designpattern.d01simple_factory;

/**
 * 工厂（Creator）角色:简单工厂模式的核心，它负责实现创建所有实例的内部逻辑。工厂类可以被外界直接调用，创建所需的产品对象
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 06:33:34
 */
public class FruitFactory {

    // 1.每个实例用一个方法创建
    // 获得Apple类的实例
    public static Fruit getApple() {
        return new Apple();
    }
    //获得Banana类实例
    public static Fruit getBanana() {
        return new Banana();
    }


    // 2.
    public static Fruit getFruit(String type) throws IllegalAccessException, InstantiationException {
		if(type.equalsIgnoreCase("apple")) {
			return Apple.class.newInstance();

		} else if(type.equalsIgnoreCase("banana")) {
			return Banana.class.newInstance();
		} else {
			System.out.println("找不到相应的实例化类");
			return null;
		}
    }

    // 3.
    public static Fruit getFruitForName(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class fruit = Class.forName(type);
        return (Fruit) fruit.newInstance();
    }

}