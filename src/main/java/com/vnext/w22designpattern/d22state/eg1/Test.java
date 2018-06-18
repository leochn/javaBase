package com.vnext.w22designpattern.d22state.eg1;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 14:00:56
 */
public class Test {

    public static void main(String[] args) {
        Person person = new Person();

        person.setHour(7);
        person.doSomething();

        person.setHour(12);
        person.doSomething();

        person.setHour(18);
        person.doSomething();

        person.setHour(8);
        person.doSomething();
    }
}