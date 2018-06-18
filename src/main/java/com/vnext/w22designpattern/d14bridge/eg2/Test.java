package com.vnext.w22designpattern.d14bridge.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 09:57:24
 */
public class Test {

    /**
     * 什么是桥接模式:
     *     通过使用封装，聚合以及继承等行为来让不同的类承担不同的责任。
     *     它的主要特点是把抽象（abstraction）与行为实现（implementation）分离开来，从而可以保持各部分的独立性以及应对它们的功能扩展。
     *
     * 桥接模式的角色和职责:
     * 1.Client
     *     Bridge模式的使用者
     * 2.Abstraction
     *     抽象类接口（接口或抽象类）
     *     维护对行为实现（Implementor）的引用
     * 3.Refined Abstraction
     *     Abstraction子类
     * 4.Implementor
     *     行为实现类接口 (Abstraction接口定义了基于Implementor接口的更高层次的操作)
     * 5.ConcreteImplementor
     *     Implementor子类
     */

    public static void main(String[] args) {

        Engine engine2000 = new Engine2000();
        Engine engine2200 = new Engine2200();

        Car car1 = new Bus(engine2000);
        car1.installEngine();

        Car car2 = new Bus(engine2200);
        car2.installEngine();

        Car jeep1 = new Jeep(engine2000);
        jeep1.installEngine();

        Car jeep2 = new Jeep(engine2200);
        jeep2.installEngine();

    }

}