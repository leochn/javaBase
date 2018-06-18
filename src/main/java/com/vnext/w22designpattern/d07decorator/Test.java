package com.vnext.w22designpattern.d07decorator;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 10:09:14
 */
public class Test {

    /**
     * 什么是装饰模式:
     * 装饰（ Decorator ）模式又叫做包装模式。通过一种对客户端透明的方式来扩展对象的功能，是继承关系的一个替换方案.
     *
     * 装饰模式的角色和职责:
     * 1.抽象组件角色：一个抽象接口，是被装饰类和装饰类的父接口。
     * 2.具体组件角色：为抽象组件的实现类。
     * 3.抽象装饰角色：包含一个组件的引用，并定义了与抽象组件一致的接口。
     * 4.具体装饰角色：为抽象装饰角色的实现类。负责具体的装饰。
     *
     */

    public static void main(String[] args) {
        Car car = new RunCar();

        car.show();
        System.out.println("---------");

        Car swimcar = new SwimCarDecorator(car);
        swimcar.show();
        System.out.println("---------");

        Car flySwimCar = new FlyCarDecorator(swimcar);
        flySwimCar.show();
    }


}