package com.vnext.w22designpattern.d16interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:32:21
 */
public class Test {
    /**
     * 什么是解释器模式:
     *     简单地说，Interpreter模式是一种简单的语法解释器构架。
     *
     * 解释器模式的角色和职责:
     * 1.Context      解释器上下文环境类。用来存储解释器的上下文环境，比如需要解释的文法等。
     * 2.AbstractExpression     解释器抽象类。
     * 3.ConcreteExpression     解释器具体实现类
     *
     */

    public static void main(String[] args) {

        String number = "20";
        Context context = new Context(number);

        List<Expression> list = new ArrayList<Expression>();
        list.add(new PlusExpression());
        list.add(new PlusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());

        for(Expression ex : list) {
            ex.interpret(context);
            System.out.println(context.getOutput());
        }
    }

}