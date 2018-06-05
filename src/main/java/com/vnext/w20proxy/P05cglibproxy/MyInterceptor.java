package com.vnext.w20proxy.P05cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author leo
 * @version 2018/6/5 6:32
 * @since 1.0.0
 */
public class MyInterceptor implements MethodInterceptor {
    /**
     * 导入cglib包
     *      <dependency>
     * 			<groupId>cglib</groupId>
     * 			<artifactId>cglib</artifactId>
     * 			<version>3.2.6</version>
     * 		</dependency>
     *
     */

    private Object target;  //目标类
    private Transaction transaction;


    public MyInterceptor(Object target, Transaction transaction) {
        super();
        this.target = target;
        this.transaction = transaction;
    }

    //创建代理对象
    public Object createProxy(){
        //代码增强类 Enhancer
        Enhancer enhancer = new Enhancer(); // 创建一个织入器
        enhancer.setCallback(this);         // 参数为拦截器, 设置需要织入的逻辑
        enhancer.setSuperclass(target.getClass()); // 生成的代理类的父类是目标类 (体现:代理类是目标类的子类)
        return enhancer.create();                  // 创建代理对象,使用织入器创建子类
    }
    //由于CGLIB可以不需要实现接口来实现动态代理,其原理是通过字节码生成类的一个子类来完成的,
    //那就有可能出现需要动态代理对象不存在一个无参构造函数,那么CGLIB在生成子类并实例化时将会产生错误.


    /**
     * @param o cglib动态生成的代理类实例，业务类的子类的实例
     * @param method 业务类方法的引用
     * @param objects 调用参数数组
     * @param methodProxy 代理类对业务类方法的代理引用，是业务类的方法的代理
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理类:" + o.getClass().getName());
        System.out.println("Before......" + method.getName() + "........");

        this.transaction.beginTransaction();
        method.invoke(target);
        this.transaction.commit();
        return null;
    }
}