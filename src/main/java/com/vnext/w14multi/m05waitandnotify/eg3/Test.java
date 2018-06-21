package com.vnext.w14multi.m05waitandnotify.eg3;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 22:05:53
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {

        String lock = new String("");

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubtract subtract1Thread = new ThreadSubtract(subtract);
        subtract1Thread.setName("subtract1Thread");
        subtract1Thread.start();

        ThreadSubtract subtract2Thread = new ThreadSubtract(subtract);
        subtract2Thread.setName("subtract2Thread");
        subtract2Thread.start();

        Thread.sleep(1000);

        ThreadAdd addThread = new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();

    }

    /**
     * 多线程中测试某个条件的变化用 if 还是用 while？
     *
     * 以前一直不明白 当在线程的run()方法中需要测试某个条件时，为什么用while，而不用if???直到看到了这个简单的例子，终于明白了。。。。
     *
     * 这个例子是这样的：
     *
     * 有两个线程从List中删除数据，而只有一个线程向List中添加数据。初始时，List为空，只有往List中添加了数据之后，才能删除List中的数据。
     * 添加数据的线程向List添加完数据后，调用notifyAll()，唤醒了两个删除线程，但是它只添加了一个数据，而现在有两个唤醒的删除线程，这时怎么办？?
     *
     * 如果用 if 测试List中的数据的个数，则会出现IndexOutofBoundException，越界异常。
     * 原因是，List中只有一个数据，第一个删除线程把数据删除后，第二个线程再去执行删除操作时，删除失败，从而抛出 IndexOutofBoundException。
     *
     * 但是如果用while 测试List中数据的个数，则不会出现越界异常！！！神奇。
     *
     * 当wait等待的条件发生变化时，会造成程序的逻辑混乱---即，List中没有数据了，再还是有线程去执行删除数据的操作。
     * 因此，需要用while循环来判断条件的变化，而不是用if。
     */
}