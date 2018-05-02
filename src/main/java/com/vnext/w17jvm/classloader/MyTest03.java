package com.vnext.w17jvm.classloader;

/**
 * @author leo
 * @since 2018/3/1 11:18
 */
public class MyTest03 {
    static {
        System.out.println("MyTest03 static block!");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
        System.out.println("---------------------");
        Parent2 parent2;
        System.out.println("================");
        parent2 = new Parent2();
        System.out.println(parent2.a);
        System.out.println(Child2.b);

    }
}

class Parent{
    static int a = 2;
    static {
        System.out.println("Parent static block!");
    }
}

class Child extends Parent {
    static int b = 3;

    static {
        System.out.println("Child static block!");
    }
}

class Parent2{
    static int a = 7;
    static {
        System.out.println("Parent2 static block!");
    }
}

class Child2 extends  Parent2{
    static int b = 8;
    static {
        System.out.println("Child2 static block!");
    }
}
