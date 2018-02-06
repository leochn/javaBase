package com.vnext.innerclass;

public class OuterClazz {
	public void method() {
		Inner inner = new Inner() {
			@Override
			public void show() {
				System.out.println("匿名内部类.show().........");
			}
		};
		inner.show();
	}
}
