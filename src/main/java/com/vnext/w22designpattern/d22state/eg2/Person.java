package com.vnext.w22designpattern.d22state.eg2;

/**
 *  Context：用户对象，拥有一个State类型的成员，以标识对象的当前状态
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 14:00:40
 */
public class Person {

    private int hour;
    private State state;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Person() {
        state = new MState();
    }

    public void doSomething(){
        state.doSomething(this);
        //复位，当所有方法完成以后再执行。
        state = new MState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}