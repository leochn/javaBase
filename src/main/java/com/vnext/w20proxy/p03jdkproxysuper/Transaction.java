package com.vnext.w20proxy.p03jdkproxysuper;

/**
 * @author leo
 * @version 2018/6/4 6:52
 * @since 1.0.0
 */
public class Transaction implements Interceptor{
    public void interceptor() {
        System.out.println("transaction");
    }
}