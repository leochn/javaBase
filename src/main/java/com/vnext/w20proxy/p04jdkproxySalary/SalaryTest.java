package com.vnext.w20proxy.p04jdkproxySalary;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author leo
 * @version 2018/6/5 6:28
 * @since 1.0.0
 */
public class SalaryTest {

    @Test
    public void testSalary(){
        Object target = new SalaryManagerImpl();
        Logger logger = new Logger();
        Security security = new Security();
        Privilege privilege = new Privilege();
        //privilege.setAccess("ASDDFF");
        privilege.setAccess("admin");
        MyInterceptor interceptor = new MyInterceptor(target, logger, security, privilege);
        SalaryManager  proxy = (SalaryManager)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), interceptor);
        proxy.showSalary();
    }
}