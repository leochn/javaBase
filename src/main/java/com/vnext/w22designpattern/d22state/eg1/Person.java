package com.vnext.w22designpattern.d22state.eg1;

/**
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

    public void doSomething(){
        if(hour == 7) {
            state = new MState();
            state.doSomething();
        } else if(hour == 12) {
            state = new LState();
            state.doSomething();
        } else if(hour == 18) {
            state = new SState();
            state.doSomething();
        } else {
            state = new NoState();
            state.doSomething();
        }
    }
}