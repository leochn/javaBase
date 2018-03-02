package com.vnext.w17jvm.classloader;

/**
 * 类的加载过程和初始化的问题
 * @author leo
 * @since 2018/3/1 8:33
 */
public class MyTest01 {

    /**
     * 类的加载过程和初始化的问题
     */
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1=" + instance.counter1);  // 1
        System.out.println("counter2=" + instance.counter2);  // 0
        System.out.println("------------------------");

        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println("counter1=" + instance2.counter1); // 1
        System.out.println("counter2=" + instance2.counter2); // 1
    }
}

class Singleton{
    private static Singleton singleton = new Singleton();
    public static int counter1;
    public static int counter2 = 0;

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance(){
        return singleton;
    }
}

class Singleton2{

    public static int counter1;
    public static int counter2 = 0;

    public static Singleton2 singleton = new Singleton2();

    private Singleton2() {
        counter1++;
        counter2++;
    }

    public static Singleton2 getInstance(){
        return singleton;
    }
}
