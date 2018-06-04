package com.vnext.w20proxy.p03jdkproxysuper;

/**
 * 给事务、日志等做了一个抽象，而这个抽象就是Interceptor
 * @author leo
 * @version 2018/6/5 5:49
 * @since 1.0.0
 */
public interface Interceptor {
    public void interceptor();
}
