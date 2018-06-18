package com.vnext.w22designpattern.d23command.eg3;

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

        // 下订单
        waiter.setOrder(appleCommand);
        waiter.setOrder(bananaCommand);

        // 移除某个订单
        waiter.removeOrder(appleCommand);

        waiter.sail();
    }

}