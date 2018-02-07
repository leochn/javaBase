/**
 * 
 */
package com.vnext.w04object;

/**
 * java对象的创建流程
 * @author leo
 * @since 2018-02-06 18:31:14
 */
public class TestJavaPojo {
	
	public static void main(String[] args) {
		// https://www.cnblogs.com/study-everyday/p/6752715.html
        Child demo = new Child();
        demo.function();
        System.out.println("…………………………………………………………………………………………………………………………");
        Child child = new Child();
        child.function();
   }
}

class Parent {
    int a = 5;
    static int b = 6;
    // 静态代码块
    static {
        System.out.println("Parent静态代码块：b=" + b);
        b++;
   }
   // 代码块
   {
       System.out.println("Parent代码块： a=" + a);
       System.out.println("Parent代码块： b=" + b);
       b++;
       a++;
   }

   // 无参构造函数
   Parent() {
       System.out.println("Parent无参构造函数： a=" + a);
       System.out.println("Parent无参构造函数： b=" + b);
   }

   // 有参构造函数
   Parent(int a) {
       System.out.println("Parent有参构造函数： a=" + a);
       System.out.println("Parent有参构造函数： b=" + b);
   }

   // 方法
   void function() {
       System.out.println("Parent function run ……");
   }

}

class Child extends Parent {
    int x = 7;
    static int y = 8;
    // 静态代码块
    static {
        System.out.println("Child静态代码块：y=" + y);
        y++;
   }
   // 代码块
   {
       System.out.println("Child代码块： x=" + x);
       System.out.println("Child代码块： y=" + y);
       y++;
       x++;
   }

   // 构造函数
   Child() {
       System.out.println("Child构造函数： x=" + x);
       System.out.println("Child构造函数： y=" + y);
   }

   // 方法
   void function() {
       System.out.println("Child function run ……");
   }

}

/*
Parent静态代码块：b=6
Child静态代码块：y=8
Parent代码块： a=5
Parent代码块： b=7
Parent无参构造函数： a=6
Parent无参构造函数： b=8
Child代码块： x=7
Child代码块： y=9
Child构造函数： x=8
Child构造函数： y=10
Child function run ……
…………………………………………………………………………………………………………………………
Parent代码块： a=5
Parent代码块： b=8
Parent无参构造函数： a=6
Parent无参构造函数： b=9
Child代码块： x=7
Child代码块： y=10
Child构造函数： x=8
Child构造函数： y=11
Child function run ……
*/
