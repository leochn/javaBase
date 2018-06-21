package com.vnext.w14multi.m05waitandnotify.eg3;

/**
 * Subtract类，负责删除数据----先要进行条件判断，然后执行wait()，这意味着：wait等待的条件可能发生变化！！！
 * @author leo
 * @version 1.0.0
 * @date 2018-06-21 22:04:06
 */
public class Subtract {
    private String lock;

    public Subtract(String lock) {
        super();
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
                //if(ValueObject.list.size() == 0) {//将这里的if改成while即可保证不出现越界异常!!!!
                while (ValueObject.list.size() == 0) {//将这里的if改成while即可保证不出现越界异常!!!!
                    System.out.println("wait begin ThreadName="
                            + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait   end ThreadName="
                            + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}