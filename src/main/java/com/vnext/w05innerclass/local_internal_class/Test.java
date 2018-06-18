package com.vnext.w05innerclass.local_internal_class;

import com.vnext.w05innerclass.others.OuterCls;

/**
 * 局部内部类:可以定义在方法内,也可以定义在作用域内
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 19:18:58
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 局部内部类，它是嵌套在方法和作用域内的，对于这个类的使用主要是应用与解决比较复杂的问题，想创建一个类来辅助我们的解决方案，
         * 到那时又不希望这个类是公共可用的，所以就产生了局部内部类，局部内部类和成员内部类一样被编译，只是它的作用域发生了改变，
         * 它只能在该方法和属性中被使用，出了该方法和属性就会失效。
         */

        ParcelClazz parcelClazz = new ParcelClazz();
        parcelClazz.method();

        System.out.println("--------------------");
        parcelClazz.track();
    }

}