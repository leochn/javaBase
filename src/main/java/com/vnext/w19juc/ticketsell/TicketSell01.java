package com.vnext.w19juc.ticketsell;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张都有一个编号，同时有10个窗口对外售票
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 07:08:03
 */
public class TicketSell01 {

    private static Vector<String> tickets = new Vector<>();

    static {
        for (int i = 0; i < 100; i++) {
            tickets.add("票编码:" + i);
        }
    }
//    // 1. Vector不能实现，操作分离
//    // size和进行的remove必须是一个原子操作,下面代码会报错：java.lang.ArrayIndexOutOfBoundsException
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                while (tickets.size() > 0){
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("销售了>>>" + tickets.remove(0));
//                }
//            }).start();
//        }
//    }

    // 2. synchronized 对操作加锁，将size和进行remove锁住一整个的原子操作
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (tickets) {
                        if (tickets.size() <= 0) break;

                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("销售了>>>" + tickets.remove(0));
                    }
                }
            }).start();
        }
    }

}