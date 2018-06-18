package com.vnext.w22designpattern.d16interpreter;

/**
 * 解释器抽象类
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:44:41
 */
public abstract class Expression {

    public abstract void interpret(Context context);

}