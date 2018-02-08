package com.vnext.w12thread;

import java.util.concurrent.Semaphore;

/**
 * @author leo
 * @since 2018-02-08 09:02:40
 */
public class ThreadCommunication {

	/*题目：三个线程 a、b、c 并发运行，b,c 需要 a 线程的数据怎么实现
		根据问题的描述，我将问题用以下代码演示，ThreadA、ThreadB、ThreadC，ThreadA 用于初始化数据 num，
		只有当 num 初始化完成之后再让 ThreadB 和 ThreadC 获取到初始化后的变量 num。
	分析过程如下：
	    考虑到多线程的不确定性，因此我们不能确保 ThreadA 就一定先于 ThreadB 和 ThreadC 前执行，就算 ThreadA先执行了，
	    我们也无法保证 ThreadA 什么时候才能将变量 num 给初始化完成。因此我们必须让 ThreadB 和 ThreadC去等待 ThreadA 完成任何后发出的消息。
	现在需要解决两个难题：
	    一是让 ThreadB 和 ThreadC 等待 ThreadA 先执行完，二是 ThreadA 执行完之后给ThreadB 和 ThreadC 发送消息。
	解决上面的难题我能想到的两种方案：
		一是使用纯 Java API 的 Semaphore 类来控制线程的等待和释放，二是使用 Android 提供的 Handler 消息机制。*/

	private static int num;

	/**
	 *  定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
	 *  线程的阻塞和释放是通过 permit 概念来实现的
	 *  线程通过 semaphore.acquire()方法获取 permit，如果当前 semaphore 有 permit 则分配给该线程，
	 *  如果没有则阻塞该线程直到 semaphore 调用 release（）方法释放 permit。 构造函数中参数：permit(允许)个数，
	 */
	private static Semaphore semaphore = new Semaphore(0);

	public static void main(String[] args) {

		Thread threadA = new Thread(() -> {
            try {
                Thread.sleep(2000);
                num = 1;
                // 初始化完参数后释放两个 permit
                semaphore.release(2);
                System.out.println(Thread.currentThread().getName() + " init num is ok!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"threadA");

		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " get num,num = " + num);
			}
		},"threadB");

		Thread threadC = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 获取 permit，如果 semaphore 没有可用的 permit 则等待，如果有则消耗一个
					semaphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " get num,num = " + num);
			}
		},"threadC");

		// run thread
		threadA.start();
		threadB.start();
		threadC.start();
	}




}
