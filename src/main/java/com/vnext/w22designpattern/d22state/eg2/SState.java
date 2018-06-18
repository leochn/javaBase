package com.vnext.w22designpattern.d22state.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:59:05
 */
public class SState extends State {

    @Override
    public void doSomething(Person person) {
        if(person.getHour() == 18) {
            System.out.println("吃晚餐了....");
        } else {
            person.setState(new NoState());
            person.doSomething();
        }
    }
}