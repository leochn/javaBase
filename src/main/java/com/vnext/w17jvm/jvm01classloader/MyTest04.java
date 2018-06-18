package com.vnext.w17jvm.jvm01classloader;

/**
 * 类的初始化时机：
        只有当程序访问的静态变量或静态方法确实在当前类或当前接口中定义时，才可以认为是对类或接口的主动使用。
 * @author leo
 * @since 2018/3/1 12:43
 */
public class MyTest04 {
    public static void main(String[] args) {
        System.out.println(Child3.a);
        Child3.doSomething();
        /**
         * 结果如下：
         Parent3 static block!
         7
         Parent3 doSomething....

         原因：
            Child3 static block! 没有打印，因为Child3并没有初始化。
         类的初始化时机：
            只有当程序访问的静态变量或静态方法确实在当前类或当前接口中定义时，才可以认为是对类或接口的主动使用。
         */
    }
}

class Parent3{
    static int a = 7;
    static {
        System.out.println("Parent3 static block!");
    }
    static void doSomething(){
        System.out.println("Parent3 doSomething....");
    }
}

class Child3 extends  Parent3{

    static {
        System.out.println("Child3 static block!");
    }
}
