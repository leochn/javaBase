package com.vnext.w05innerclass.member_internal_class;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-02-16 18:06:06
 */
public class Test01 {

    public static void main(String[] args) {
        MemberOuter.MemberInner memberInner = new MemberOuter().new MemberInner(); // 非静态内部类要new实例
        memberInner.doSomething();
    }

}