package com.vnext.w17jvm.classloader;

/**
 * 类的加载过程和初始化的问题
 * @author leo
 * @since 2018/3/1 8:33
 */
public class MyTest01 {

    /**
     * 类的加载过程和初始化的问题：初次体验类的初始化过程.

     硬盘上的一个class文件到能够正常执行，在执行之前，需要经过3个步骤：类的加载、连接、初始化
        1.加载：查找并加载类的二进制数据
        2.连接：
            验证：确保被加载的类的正确性
            准备：为类的静态变量分配内存，并将其初始化为默认值
            解析：把类中的符号引用转换为直接引用
        3.初始化：为类的静态变量赋予正确的初始值
     */

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1=" + instance.counter1);  // 1
        System.out.println("counter2=" + instance.counter2);  // 0
        System.out.println("------------------------");

        Singleton2 instance2 = Singleton2.getInstance();
        System.out.println("counter1=" + instance2.counter1); // 1
        System.out.println("counter2=" + instance2.counter2); // 1

        System.out.println("------------------------");
        Singleton3 instance3 = new Singleton3();
        System.out.println("counter1=" + instance3.counter1); // 2
        System.out.println("counter2=" + instance3.counter2); // 1

        System.out.println("------------------------");
        Singleton04 instance4 = new Singleton04();
        System.out.println("counter1=" + instance4.counter1); // 4
        System.out.println("counter2=" + instance4.counter2); // 2

        // 为什么会是这种结果:


    }
}

class Singleton{
    // 生成对象的语句在 2个变量之前.
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

    // 生成对象的语句在 2个变量之后.
    public static Singleton2 singleton = new Singleton2();
    public static int counter1;
    public static int counter2 = 0;

    private Singleton2() {
        counter1++;
        counter2++;
    }

    public static Singleton2 getInstance(){
        return singleton;
    }
}

class Singleton3 {
    private static Singleton3 singleton = new Singleton3();
    public static int counter1;
    public static int counter2 = 0;

    public Singleton3() {
        counter1++;
        counter2++;
    }
}

class Singleton04 {

    public static int counter1;
    public static int counter2 = 0;
    private static Singleton04 sin = new Singleton04();

    {
        counter1=3;
    }

    public Singleton04() {
        counter1++;
        counter2++;
    }

}
