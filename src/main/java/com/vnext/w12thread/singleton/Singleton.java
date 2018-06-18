/**
 * 
 */
package com.vnext.w12thread.singleton;

/**
 * 懒汉式
 * @author leo
 * @since 2018-02-06 18:04:53
 */
public class Singleton {
	//关于懒汉式的线程安全问题：使用同步机制
	//对于一般的方法内，使用同步代码块，可以考虑使用this。
	//对于静态方法而言，使用当前类本身充当锁。
	private Singleton() {}
	
	private static Singleton instance = null;
	
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}



