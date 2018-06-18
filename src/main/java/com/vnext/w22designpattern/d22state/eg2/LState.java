package com.vnext.w22designpattern.d22state.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:59:37
 */
public class LState extends State {

    @Override
    public void doSomething(Person person) {
        if(person.getHour() == 12) {
            System.out.println("吃中饭......");
        } else {
            person.setState(new SState());
            person.doSomething();
        }
    }
}