package com.vnext.w14multi.m03base;

import java.util.concurrent.DelayQueue;

/**
 * 是一个无界的BlockingQueue，用于放置实现了Delayed接口的对象，其中的对象只能在其到期时才能从队列中取走。
 * 这种队列是有序的，即队头对象的延迟到期时间最长。注意：不能将null元素放置到这种队列中。
 * @author leo
 * @version 1.0.0
 * @date 2018-06-19 18:49:33
 */
public class T02DelayQueue implements Runnable {

    private DelayQueue<Wangmin> queue = new DelayQueue<Wangmin>();

    public boolean yinye =true;

    public void shangji(String name,String id,int money){
        Wangmin man = new Wangmin(name, id, 1000 * money + System.currentTimeMillis());
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"交钱"+money+"块,开始上机...");
        this.queue.add(man);
    }

    public void xiaji(Wangmin man){
        System.out.println("网名"+man.getName()+" 身份证"+man.getId()+"时间到下机...");
    }

    @Override
    public void run() {
        while(yinye){
            try {
                Wangmin man = queue.take();
                xiaji(man);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        try{
            System.out.println("网吧开始营业");
            T02DelayQueue siyu = new T02DelayQueue();
            Thread shangwang = new Thread(siyu);
            shangwang.start();

            siyu.shangji("路人甲", "123", 1);
            siyu.shangji("路人乙", "234", 10);
            siyu.shangji("路人丙", "345", 5);
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}