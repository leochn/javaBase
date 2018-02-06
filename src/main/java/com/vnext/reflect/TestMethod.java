package com.vnext.reflect;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author leo
 * @version 2018/1/28 9:04
 * @since 1.0.0
 */
public class TestMethod {
    //1.获取运行时类的方法

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        //1.getMethods():获取运行时类及其父类中所有的声明为public的方法
        Method[] m1 = clazz.getMethods();
        for(Method m : m1){
            System.out.println(m);
        }
        System.out.println();

        //2.getDeclaredMethods():获取运行时类本身声明的所有的方法
        Method[] m2 = clazz.getDeclaredMethods();
        for(Method m : m2){
            System.out.println(m);
        }
    }


    // 注解，权限修饰符，返回值类型，方法名，形参列表，异常
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;

        Method[] m2 = clazz.getDeclaredMethods();
        for(Method m : m2){
            //1.注解
            Annotation[] ann = m.getAnnotations();
            for(Annotation a : ann){
                System.out.println("注解annotation:" + a);
            }


            //2.权限修饰符
            String str = Modifier.toString(m.getModifiers());
            System.out.print(str + " ");
            //3.返回值类型
            Class<?> returnType = m.getReturnType();
            System.out.print( returnType.getName() + " ");
            //4.方法名
            System.out.print(m.getName());

            //5.形参列表
            System.out.print("(");
            @SuppressWarnings("rawtypes")
			Class[] params = m.getParameterTypes();
            for(int i = 0;i < params.length;i++){
                System.out.print(params[i].getName() + " args-" + i + " ");
            }
            System.out.print(")");

            //6.异常类型
            @SuppressWarnings("rawtypes")
			Class[] exps = m.getExceptionTypes();
            if(exps.length != 0){
                System.out.print("throws ");
            }
            for (Class<?> exp : exps) {
                System.out.print(exp.getName() + " ");
            }
            System.out.println();
        }
    }


    //调用运行时类中指定的方法
    @Test
    public void test3() throws Exception{
        Class<Person> clazz = Person.class;
        // getMethod(String methodName,Class ... params):获取运行时类中声明为public的指定的方法
        Method m1 = clazz.getMethod("show");
        Person p = clazz.newInstance();
        // 调用指定的方法：Object invoke(Object obj,Object ... obj)
        Object returnVal = m1.invoke(p);// 我是一个人
        System.out.println(returnVal);  // null

        Method m2 = clazz.getMethod("toString");
        Object returnVal1 = m2.invoke(p);
        System.out.println(returnVal1);//Person [name=null, age=0]
        // 对于运行时类中静态方法的调用
        Method m3 = clazz.getMethod("info");
        m3.invoke(Person.class);

        //getDeclaredMethod(String methodName,Class ... params):获取运行时类中声明了的指定的方法
        Method m4 = clazz.getDeclaredMethod("display",String.class,Integer.class);
        m4.setAccessible(true);
        Object value = m4.invoke(p,"CHN",10);  // 我的国籍是：CHN
        System.out.println(value);  // 10
    }

}
