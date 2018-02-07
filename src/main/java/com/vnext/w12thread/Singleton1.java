/**
 * 
 */
package com.vnext.w12thread;

/**
 * 饿汉式单例是指在方法调用前，实例就已经创建好了
 * @author leo
 * @since 2018-02-06 18:24:05
 */
public class Singleton1 {
	private static Singleton1 instance = new Singleton1();
	private Singleton1() {}
	
	public static Singleton1 getInstance() {
		return instance;
	}
}
