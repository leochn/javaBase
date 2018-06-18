package com.vnext.w22designpattern.d22state.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:58:19
 */
public class MState extends State {

    @Override
    public void doSomething(Person person) {
        if(person.getHour() == 7) {
            System.out.println("吃早餐......");
        } else {
            person.setState(new LState());
            person.doSomething();
        }
    }
}