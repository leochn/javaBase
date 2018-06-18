package com.vnext.w22designpattern.d23command.eg2;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 14:41:43
 */
public class Test {

    /**
     * 什么是命令模式:
     *     Command模式通过被称为Command的类封装了对目标对象的调用行为以及调用参数。
     */

    public static void main(String[] args) {
        Peddler peddler = new Peddler();

        Command appleCommand = new AppleCommand(peddler);
        Command bananaCommand = new BananaCommand(peddler);
//		appleCommand.sail();
//		bananaCommand.sail();

        Waiter waiter = new Waiter();
        waiter.setCommand(appleCommand);
        waiter.sail();
        waiter.setCommand(bananaCommand);
        waiter.sail();
    }

}