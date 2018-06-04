package com.vnext.w20proxy.P05cglibproxy;

/**
 * @author leo
 * @version 2018/6/5 6:31
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