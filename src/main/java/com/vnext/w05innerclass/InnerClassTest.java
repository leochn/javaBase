package com.vnext.w05innerclass;

import com.vnext.w05innerclass.Outer.InnerCls;

/**
 * 内部类测试
 * 
 * @author leo
 * @data 2018-01-03 13:50:35
 */
public class InnerClassTest {
	public static void main(String[] args) {
		// 需求:要访问Inner类的show方法
		Outer.Inner inner = new Outer().new Inner();
		inner.show();
		InnerCls.inner_f1();
		Outer.InnerCls.inner_f1();
		System.out.println("-----------------------------");
		OuterCls outerCls = new OuterCls();
		outerCls.method();
		System.out.println("-----------------------------");
		OuterClazz outerClazz = new OuterClazz();
		outerClazz.method();
		System.out.println("-----------------------------");
		PersonDemo pd = new PersonDemo();
		Person person = new Student();
		pd.method(person);
		System.out.println("----------------");
		pd.method(new Person(){
			@Override
			public void study() {
				System.out.println("Good Good Study,Day Day Up!");
			}
		});
	}
}
