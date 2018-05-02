package com.vnext.w17jvm.classloader;

import java.util.Random;

/**
 * @author leo
 * @since 2018/3/1 8:46
 */
public class MyTest02 {

    public static void main(String[] args) {

        System.out.println(TestClass01.x);
        System.out.println("----------------");
        System.out.println(TestClass02.x);
        System.out.println("----------------");
        System.out.println(TestClass03.x);
        /**
         * 输出结果：
         2
         ----------------
         TestClass02 static block
         24
         ----------------
         TestClass01 static block
         2


         分析：
            涉及到类的初始化问题，类初始化才会执行static的静态代码块。
            java对类的使用分为主动使用和被动使用。
            主动使用的6种情况：
                1.创建类的实例
                2.访问某个类或接口的静态变量，或者对该静态变量赋值
                3.调用类的静态方法
                4.反射（如Class.forName("com.vnext.example.Test")）
                5.初始化一个类的子类
                6.Java虚拟机启动时被标明为启动类的类（Java Test）
            除了上述六种情形，其他使用Java类的方式都被看作是被动使用，不会导致类的初始化。
         */
    }
}

class TestClass01{

    public static final int x = 6/3;  // 在编译的时候，已经把final 变量 x 赋值成2

    static {
        System.out.println("TestClass01 static block");
    }

}

class TestClass02{

    public static final int x = new Random().nextInt(100); // x 的值在运行时动态生成


    static {
        System.out.println("TestClass02 static block");
    }

}


class TestClass03{

    public static int x = 6/3;

    static {
        System.out.println("TestClass01 static block");
    }

}

