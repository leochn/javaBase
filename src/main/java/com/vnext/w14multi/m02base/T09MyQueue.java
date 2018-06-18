package com.vnext.w14multi.m02base;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-18 21:49:53
 */
public class T09MyQueue {

    //1 需要一个承装元素的集合
    private LinkedList<Object> list = new LinkedList<Object>();

    //2 需要一个计数器
    private AtomicInteger count = new AtomicInteger(0);

    //3 需要制定上限和下限
    private final int minSize = 0;

    private final int maxSize ;

    //4 构造方法
    public T09MyQueue(int size){
        this.maxSize = size;
    }

    //5 初始化一个对象 用于加锁
    private final Object lock = new Object();


    // wait 和 notify 必须配合 synchronized 关键字使用。
    // wait 方法释放锁，notify 方法不释放锁。
    //put(anObject): 把anObject加到BlockingQueue里,如果BlockQueue没有空间,则调用此方法的线程被阻断，直到BlockingQueue里面有空间再继续.
    public void put(Object obj) {
        synchronized (lock) {
            while (count.get() == this.maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //1 加入元素
            list.add(obj);
            //2 计数器累加
            count.incrementAndGet();
            //3 通知另外一个线程（唤醒）
            lock.notify();
            System.out.println("新加入的元素为:" + obj);
        }
    }


    //take: 取走BlockingQueue里排在首位的对象,若BlockingQueue为空,阻断进入等待状态直到BlockingQueue有新的数据被加入.
    public Object take() {
        Object ret = null;
        synchronized (lock) {
            while (count.get() == this.minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //1 做移除元素操作
            ret = list.removeFirst();
            //2 计数器递减
            count.decrementAndGet();
            //3 唤醒另外一个线程
            lock.notify();
        }
        return ret;
    }

    public int getSize(){
        return this.count.get();
    }


    public static void main(String[] args) {

        final T09MyQueue mq = new T09MyQueue(5);
        mq.put("a");
        mq.put("b");
        mq.put("c");
        mq.put("d");
        mq.put("e");

        System.out.println("当前容器的长度:" + mq.getSize());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mq.put("f");
                mq.put("g");
            }
        },"t1");

        t1.start();


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object o1 = mq.take();
                System.out.println("移除的元素为:" + o1);
                Object o2 = mq.take();
                System.out.println("移除的元素为:" + o2);
            }
        },"t2");


        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();


    }

}