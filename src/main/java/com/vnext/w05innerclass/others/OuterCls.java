package com.vnext.w05innerclass.others;

/**
 * 局部内部类
 * @author leo
 * @date 2018-01-03 14:15:58
 */
public class OuterCls {
	private int num = 10;
	public void method(){
		int num2 = 20;
		final int num3 = 30;
		class Inner{
			private void show() {
				System.out.println("inner-num = " + num);  //10
				System.out.println("inner-num2 = " + num2);//20
				System.out.println("inner-num3 = " + num3);//30
			}
		}
		System.out.println("num2 = " + num2);//20
		Inner inner = new Inner();
		inner.show();
	}
}
