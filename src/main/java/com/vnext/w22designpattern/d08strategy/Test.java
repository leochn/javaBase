package com.vnext.w22designpattern.d08strategy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 11:07:30
 */
public class Test {
    /**
     * 什么是策略模式:
     *    Strategy模式也叫策略模式是行为模式之一，它对一系列的算法加以封装，为所有算法定义一个抽象的算法接口，
     * 并通过继承该抽象算法接口对所有的算法加以封装和实现，具体的算法选择交由客户端决定（策略）。
     * Strategy模式主要用来平滑地处理算法的切换。
     *
     * Strategy:
     *    策略（算法）抽象。
     *
     * ConcreteStrategy
     *    各种策略（算法）的具体实现。
     *
     * Context
     *    策略的外部封装类，或者说策略的容器类。根据不同策略执行不同的行为。策略由外部环境决定。
     *
     * 策略模式的优点：
     * 1. 策略模式提供了管理相关的算法族的办法。策略类的等级结构定义了一个算法或行为族。
     *    恰当使用继承可以把公共的代码移到父类里面，从而避免重复的代码。
     *
     * 策略模式的缺点：
     * 1. 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。这就意味着客户端必须理解这些算法的区别，以便适时选择恰当的算法类。
     *    换言之，策略模式只适用于客户端知道所有的算法或行为的情况。
     */


    public static void main(String[] args) {
        double num = 200;

        //Context context = new Context(new StrategyB());
        Context context = new Context(new StrategyA());
        double newNum = context.cost(num);
        System.out.println("实际付账" + newNum + "元");
    }

}