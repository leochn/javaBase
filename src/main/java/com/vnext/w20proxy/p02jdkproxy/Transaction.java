package com.vnext.w20proxy.p02jdkproxy;

/**
 * @author leo
 * @version 2018/6/4 6:52
 * @since 1.0.0
 */
public class Transaction {
    public void beginTransaction(){
        System.out.println("begin transaction");
    }

    public void commit(){
        System.out.println("commit");
    }
}