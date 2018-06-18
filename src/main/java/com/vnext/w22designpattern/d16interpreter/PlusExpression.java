package com.vnext.w22designpattern.d16interpreter;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 10:45:52
 */
public class PlusExpression extends Expression {

    @Override
    public void interpret(Context context) {
        //提示信息
        System.out.println("自动递增");
        //获得上下文环境
        String input = context.getInput();
        //进行类型转换
        int intInput = Integer.parseInt(input);
        //进行递增
//		intInput++;
        ++intInput;
        //对上下文环境重新进行赋值
        context.setInput(String.valueOf(intInput));
        context.setOutput(intInput);
    }
}