package com.vnext.w15jdk8.exer;

import org.junit.Test;

/**
 * @author leo
 * @version 2018/2/28 20:56
 * @since 1.0.0
 */
public class TestDefaultInterface {

    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        // 接口默认方法的"类优先"原则
        System.out.println(subClass.getName());
    }

    @Test
    public void test1(){
        SubClass2 subClass2 = new SubClass2();
        System.out.println(subClass2.getName());

        // 使用接口中的静态方法
        MyFun2.show();
    }

}
