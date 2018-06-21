package com.vnext.w14multi.m07masterworker;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-22 07:20:38
 */
public class MyWorker extends Worker {

    public static Object handle(Task input) {
        Object output = null;
        try {
            //表示处理task任务的耗时，可能是数据的加工，也可能是操作数据库...
            Thread.sleep(500);
            output = input.getPrice();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}