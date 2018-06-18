package com.vnext.w22designpattern.d11proxy;

import java.lang.reflect.Proxy;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:29:00
 */
public class Test {

    /**
     * 什么是代理模式:
     * 是指具有与代理元（被代理的对象）具有相同的接口的类，客户端必须通过代理与被代理的目标类交互，
     * 而代理一般在交互的过程中（交互前后），进行某些特别的处理。
     */


    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();

        DynamicProxy dynamicProxy = new DynamicProxy();
        dynamicProxy.setRealSubject(realSubject);

        Subject proxySubject = (Subject)Proxy.newProxyInstance(RealSubject.class.getClassLoader(), realSubject.getClass().getInterfaces(), dynamicProxy);
        proxySubject.sailBook();
    }

}