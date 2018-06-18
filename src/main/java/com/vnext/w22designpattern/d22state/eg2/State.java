package com.vnext.w22designpattern.d22state.eg2;

/**
 * State：接口或基类，封装与Context的特定状态相关的行为
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 13:57:39
 */
public abstract class State {
    public abstract void  doSomething(Person person);
}