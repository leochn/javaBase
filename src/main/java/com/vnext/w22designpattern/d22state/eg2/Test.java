package com.vnext.w22designpattern.d22state.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 14:00:56
 */
public class Test {

    /**
     * 什么是状态模式:
     *     State模式允许通过改变对象的内部状态而改变对象的行为，这个对象表现得就好像修改了它的类一样。
     *
     * 状态模式的应用场景：
     *     状态模式主要解决的是当控制一个对象状态转换的条件表达式过于复杂时的情况。
     *     把状态的判断逻辑转译到表现不同状态的一系列类当中，可以把复杂的判断逻辑简化。
     *
     */

    public static void main(String[] args) {

        Person person = new Person();

        person.setHour(12);
        person.doSomething();

        person.setHour(18);
        person.doSomething();

        person.setHour(7);
        person.doSomething();

        person.setHour(8);
        person.doSomething();

        person.setHour(7);
        person.doSomething();

        person.setHour(18);
        person.doSomething();
    }
}