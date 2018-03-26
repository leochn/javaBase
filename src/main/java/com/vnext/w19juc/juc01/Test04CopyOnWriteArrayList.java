package com.vnext.w19juc.juc01;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author leo
 * @version 2018/3/24 15:26
 * @since 1.0.0
 */
public class Test04CopyOnWriteArrayList {
    /*
     * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
     * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
     */

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable{

    //private static List<String> list = Collections.synchronizedList(new ArrayList<>()); // Exception in thread "Thread-9" Exception in thread "Thread-8" java.util.ConcurrentModificationException

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        for (String s : list) {
            System.out.println(s);
            list.add("asd");
        }
    }
}
