/**
 * 
 */
package com.vnext.w12thread;

/**
 * @author leo
 * @since 2018-02-06 18:00:19
 */
public class DeadLock {
	//死锁的问题：处理线程同步时容易出现。
	//不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
	//写代码时，要避免死锁！
	static StringBuffer sb1 = new StringBuffer();
	static StringBuffer sb2 = new StringBuffer();
	
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				synchronized (sb1) {
					// 获取了sb1锁资源
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("A");
					// 等待sb2锁资源...
					synchronized (sb2) {
						sb2.append("B");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();

		new Thread() {
			public void run() {
				synchronized (sb2) {
					// 获取了sb2锁资源
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sb1.append("C");
					// 等待sb1锁资源...
					synchronized (sb1) {
						sb2.append("D");
						System.out.println(sb1);
						System.out.println(sb2);
					}
				}
			}
		}.start();
	}

}
