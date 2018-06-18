/**
 * 
 */
package com.vnext.w12thread.singleton;

/**
 * 单例-多线程测试
 * @author leo
 * @since 2018-02-06 18:18:11
 */
public class TestSingleton1 extends Thread{

	@Override
	public void run() {
		System.out.println(Singleton1.getInstance().hashCode());
	}
	
	public static void main(String[] args) {
		TestSingleton1[] ts = new TestSingleton1[500];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new TestSingleton1();
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
	}

}
