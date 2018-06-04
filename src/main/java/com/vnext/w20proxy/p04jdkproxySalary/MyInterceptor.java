package com.vnext.w20proxy.p04jdkproxySalary;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author leo
 * @version 2018/6/5 6:27
 * @since 1.0.0
 */
public class MyInterceptor implements InvocationHandler {
    private Object target;
    private Logger logger;
    private Security security;
    private Privilege privilege;

    public MyInterceptor(Object target, Logger logger, Security security,
                         Privilege privilege) {
        super();
        this.target = target;
        this.logger = logger;
        this.security = security;
        this.privilege = privilege;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        /**
         * 1、启动日志
         * 2、启动安全性的类
         * 3、验证权限
         *      调用目标对象的目标方法
         */
        this.logger.logging();
        this.security.security();
        if("admin".equals(this.privilege.getAccess())){
            method.invoke(target);//目标方法
        }else{
            System.out.println("没有权限查看工资");
        }
        return null;
    }
}