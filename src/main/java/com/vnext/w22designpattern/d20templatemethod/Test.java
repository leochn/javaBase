package com.vnext.w22designpattern.d20templatemethod;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 12:44:21
 */
public class Test {

    /**
     * 什么是模板方法模式:
     *     它把具有特定步骤算法中的某些必要的处理委让给抽象方法，通过子类继承对抽象方法的不同实现改变整个算法的行为。
     *
     * 模板方法模式的应用场景:
     * 1.具有统一的操作步骤或操作过程
     * 2.具有不同的操作细节
     * 3.存在多个具有同样操作步骤的应用场景，但某些具体的操作细节却各不相同
     *
     * 模板方法模式的角色和职责:
     * 1.AbstractClass： 抽象类的父类
     * 2.ConcreteClass： 具体的实现子类
     * 3.templateMethod()： 模板方法
     * 4.method1()与method2()：具体步骤方法
     *
     */


    public static void main(String[] args) {
        MakeCar bus = new MakeBus();
//		bus.makeHead();
//		bus.makeBody();
//		bus.makeTail();
        bus.make();

        System.out.println("-------------------");

        MakeCar jeep = new MakeJeep();
		jeep.makeHead();
		jeep.makeBody();
		jeep.makeTail();
        System.out.println("======");
        jeep.make();

    }

}