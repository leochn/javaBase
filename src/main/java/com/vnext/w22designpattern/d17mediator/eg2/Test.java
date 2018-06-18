package com.vnext.w22designpattern.d17mediator.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:58:50
 */
public class Test {
    /**
     * 什么是中介者模式:
     *     在Mediator模式中，类之间的交互行为被统一放在Mediator的对象中，对象通过Mediator对象同其他对象交互，Mediator对象起着控制器的作用。
     *
     * 中介者模式的角色和职责:
     * 1.mediator
     *     中介者类的抽象父类。
     * 2.concreteMediator
     *     具体的中介者类。
     * 3.colleague   关联类的抽象父类。
     * 4.concreteColleague   具体的关联类。
     *
     */

    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Person zhangsan = new Man("张三",7,mediator);
        Person lisi = new Man("李四",7,mediator);
        Person xiaofang = new Woman("小芳",7,mediator);

        zhangsan.getPartner(lisi);

        xiaofang.getPartner(lisi);
    }
}