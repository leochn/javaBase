/**
 * 
 */
package com.vnext.w12thread.singleton;

/**
 * 单例-多线程测试
 * @author leo
 * @since 2018-02-06 18:18:11
 */
public class TestSingleton extends Thread{

	@Override
	public void run() {
		System.out.println(Singleton.getInstance().hashCode());
	}
	
	public static void main(String[] args) {
		TestSingleton[] ts = new TestSingleton[500];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new TestSingleton();
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
	}

}
