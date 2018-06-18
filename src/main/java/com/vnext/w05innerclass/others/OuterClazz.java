package com.vnext.w05innerclass.others;

/**
 * 匿名内部类
 */
public class OuterClazz {

	public void method() {

		// 使用匿名内部类直接new接口
		IShow iShow = new IShow() {
			@Override
			public void show() {
				System.out.println("匿名内部类.show().........");
			}
		};
		iShow.show();
	}
}
