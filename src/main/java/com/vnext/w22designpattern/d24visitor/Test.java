package com.vnext.w22designpattern.d24visitor;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 15:24:30
 */
public class Test {

    /**
     * 什么是访问者模式:
     *     它分离对象的数据和行为，使用Visitor模式，可以不修改已有类的情况下，增加新的操作。
     *
     * 访问者模式的应用示例:
     *     比如有一个公园，有一到多个不同的组成部分；该公园存在多个访问者。
     *     清洁工A负责打扫公园的A部分，清洁工B负责打扫公园的B部分，
     *     公园的管理者负责检点各项事务是否完成，上级领导可以视察公园等等。
     *     也就是说，对于同一个公园，不同的访问者有不同的行为操作，
     *     而且访问者的种类也可能需要根据时间的推移而变化（行为的扩展性）。
     *
     * 访问者模式的角色和职责：
     * 1) 访问者角色（Visitor）：
     *      为该对象结构中具体元素角色声明一个访问操作接口。该操作接口的名字和参数标识了发送访问请求给具体访问者的具体元素角色。
     *      这样访问者就可以通过该元素角色的特定接口直接访问它。
     * 2) 具体访问者角色（Concrete Visitor）：
     *      实现每个由访问者角色（Visitor）声明的操作。
     * 3) 元素角色（Element）：
     *       定义一个Accept操作，它以一个访问者为参数。
     * 4) 具体元素角色（Concrete Element）：
     *      实现由元素角色提供的Accept操作。
     * 5) 对象结构角色（Object Structure）：
     *       这是使用访问者模式必备的角色。它要具备以下特征：能枚举 它的元素；
     *       可以提供一个高层的接口以允许该访问者访问它的元素；可以是一个复合（组合模式）或是一个集合，如一个列表或一个无序集合。
     */


    public static void main(String[] args) {
        Park park = new Park();
        park.setName("越秀公园");
        VisitorA visitorA = new VisitorA();

        park.accept(visitorA);

        VisitorB visitorB = new VisitorB();
        park.accept(visitorB);

        VisitorManager visitorManager = new VisitorManager();
        park.accept(visitorManager);
    }

}