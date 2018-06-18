package com.vnext.w22designpattern.d16interpreter;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:45:16
 */
public class MinusExpression extends Expression {

    @Override
    public void interpret(Context context) {
        System.out.println("自动递减");
        String input = context.getInput();
        int inInput = Integer.parseInt(input);
        --inInput;
        context.setInput(String.valueOf(inInput));
        context.setOutput(inInput);
    }
}