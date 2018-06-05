package com.vnext.w20proxy.P05cglibproxy;

import org.junit.Test;

/**
 * 通过cglib产生的代理对象，代理类是目标类的子类
 * @author leo
 * @version 2018/6/5 6:38
 * @since 1.0.0
 */
public class CGLibProxyTest {
    /**
     * JDK动态代理和CGLIB字节码生成的区别？
     *  （1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类
     *  （2）CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法
     *       因为是继承，所以该类或方法最好不要声明成final
     *
     *   (3)jdk代理，代理类和目标类实现了共同的接口
     *      通过cglib产生的代理对象，代理类是目标类的子类 --> enhancer.setSuperclass(target.getClass());
     */
    @Test
    public void testCGlib(){
        Object target = new PersonDaoImpl();
        Transaction transaction = new Transaction();
        MyInterceptor interceptor = new MyInterceptor(target, transaction);
        // cglib动态代理不需要接口.
        PersonDaoImpl proxy = (PersonDaoImpl)interceptor.createProxy();
        // 生成的代理对象proxy,代理对象的方法(proxy.savePerson),就把目标对象(target)和切面(transaction)结合在一起了.
        // --> 代理方法 = 目标方法 + 通知
        // 目标方法和通知是完全松耦合的
        proxy.savePerson();
    }
}