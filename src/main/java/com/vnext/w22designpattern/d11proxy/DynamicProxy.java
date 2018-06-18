package com.vnext.w22designpattern.d11proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-17 16:32:35
 */
public class DynamicProxy implements InvocationHandler {

    //　这个就是我们要代理的真实对象
    private RealSubject realSubject;

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        discount();
        try {
            result = method.invoke(realSubject, args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        coupon();
        return result;
    }

    public void discount() {
        System.out.println("书打折了......");
    }

    public void coupon() {
        System.out.println("优惠券......");
    }
}