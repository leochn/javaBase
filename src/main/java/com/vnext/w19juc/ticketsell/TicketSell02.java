package com.vnext.w19juc.ticketsell;

import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/**
 * 有N张火车票，每张都有一个编号，同时有10个窗口对外售票
 *
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 07:08:03
 */
public class TicketSell02 {

    private static Queue<String> tickets = new ConcurrentLinkedQueue<>();

    static {
        for (int i = 0; i < 10000; i++) {
            tickets.add("票编码:" + i);
        }
    }

    // 使用ConcurrentQuene(并发队列)，提高并发性，效率最高
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String s = tickets.poll();
                    if ( s == null) break;

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("销售了 ---->>>> " + s);
                }
            }).start();
        }
    }

}