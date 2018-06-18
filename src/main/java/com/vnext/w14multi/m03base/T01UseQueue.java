package com.vnext.w14multi.m03base;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-19 06:47:49
 */
public class T01UseQueue {
    /**
     * ConcurrentLinkedQueue：
     *     是一个适用于高并发场景下的队列，通过无锁的方式，实现了高并发状态下的高性能，
     *     通常 ConcurrentLinkedQueue 性能好与 BlockingQueue。
     * ConcurrentLinkedQueue 的重要方法：
     *     add(),offer()都是加入元素的方法.(在ConcurrentLinkedQueue中,这两方法没有任何区别)
     *     poll(),peek()都是取头元素节点,区别在于前者会删除元素,后者不会.
     *
     *
     */

    public static void main(String[] args) throws InterruptedException {

        // ConcurrentLinkedQueue：高性能无阻塞无界队列
        ConcurrentLinkedQueue<String> concurrentLinkedQueue = new ConcurrentLinkedQueue<String>();
        concurrentLinkedQueue.offer("a");
        concurrentLinkedQueue.offer("b");
        concurrentLinkedQueue.offer("c");
        concurrentLinkedQueue.offer("d");
        concurrentLinkedQueue.add("e");

        System.out.println(concurrentLinkedQueue.poll());    //a 从头部取出元素，并从队列里删除
        System.out.println(concurrentLinkedQueue.size());    //4
        System.out.println(concurrentLinkedQueue.peek());    //b
        System.out.println(concurrentLinkedQueue.size());    //4
        System.out.println("---------------------------");



        // ArrayBlockingQueue:基于数组的阻塞队列实现，有界队列
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<String>(5);
        array.put("a");
        array.put("b");
        array.add("c");
        array.add("d");
        array.add("e");
        // array.offer("a", 2, TimeUnit.SECONDS);如果2秒还不能加上去,就返回false
        System.out.println(array.offer("a", 2, TimeUnit.SECONDS));
        System.out.println("---------------------------");

        // LinkedBlockingQueue：基于链表的阻塞队列，无界队列
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
        linkedBlockingQueue.offer("a");
        linkedBlockingQueue.offer("b");
        linkedBlockingQueue.offer("c");
        linkedBlockingQueue.offer("d");
        linkedBlockingQueue.offer("e");
        linkedBlockingQueue.add("f");
        System.out.println(linkedBlockingQueue.size());

		for (Iterator iterator = linkedBlockingQueue.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
        System.out.println("==============================");

        List<String> list = new ArrayList<String>();
        System.out.println(linkedBlockingQueue.drainTo(list, 3));
        System.out.println(list.size());
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("==============================");


		// SynchronousQueue:一种没有缓冲的队列，生产者产生的数据直接会被消费者获取并消费
        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronousQueue.add("asdasd");
            }
        });
        t2.start();

    }



}