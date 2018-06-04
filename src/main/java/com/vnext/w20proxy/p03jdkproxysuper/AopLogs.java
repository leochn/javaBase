package com.vnext.w20proxy.p03jdkproxysuper;

/**
 * @author leo
 * @version 2018/6/5 5:58
 * @since 1.0.0
 */
public class AopLogs implements Interceptor{

    @Override
    public void interceptor() {
        System.out.println("aop logs....");
    }
}