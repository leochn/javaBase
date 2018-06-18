package com.vnext.w22designpattern.d22state.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 14:00:04
 */
public class NoState extends State {

    @Override
    public void doSomething(Person person) {
        System.out.println(person.getHour() +  ", 未定义....");
    }
}