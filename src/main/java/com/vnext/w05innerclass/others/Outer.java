package com.vnext.w05innerclass.others;

/**
 * 成员内部类,静态成员内部类
 * @author leo
 * @date 2018-01-03 13:51:05
 */
public class Outer {
	/*
	注意：
	内部类是一个编译时的概念，一旦编译成功，就会成为完全不同的两类。
	对于一个名为outer的外部类和其内部定义的名为inner的内部类。
	编译完成后出现outer.class和outer$inner.class两类。*/
	private int num = 10;
	private static int i = 1;
	public void outShow() {
		System.out.println("num = " + num);
	}
	
	public static void outer_f1() {
		System.out.println("static-i = " + i);
	}
	
	// 成员内部类:作为外部类的一个成员存在，与外部类的属性、方法并列
	// 成员内部类中不能定义静态变量,但可以访问外部类的所有成员
	public class Inner{
		//private static String str; // 成员内部类中不能定义静态变量
		
		// 用内部类定义在外部类中不可访问的属性。这样就在外部类中实现了比外部类的private还要小的访问权限
		private String name = "hello innerClass";
		//private int num = 100; // 内部类和外部类的变量可以同名
		
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		public Inner() {
			// TODO Auto-generated constructor stub
		}
		
		public Inner(String name){
			this.name = name;
		}

		public void show(){
			System.out.println("num = " + num);           //num = 10
			System.out.println("name = " + this.name);    //name = hello innerClass
		}
	}

	// 静态成员内部类
	static class InnerCls {
		static int inner_i = 100;
		int inner_j = 200;

		static void inner_f1() {
			System.out.println("MemberOuter.i = " + i);// 静态内部类只能访问外部类的静态成员
			outer_f1();// 包括静态变量和静态方法
		}

		void inner_f2() {
			// System.out.println("MemberOuter.i"+j);//静态内部类不能访问外部类的非静态成员
			// outer_f2();//包括非静态变量和非静态方法
		}
	}
}
