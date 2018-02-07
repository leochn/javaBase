package com.vnext.w13reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * 
 * @author leo
 * @version  2018-01-26 21:22:59
 */
public class TestConstructor {
	
	@Test
	public void test1() throws Exception{
		String className = "com.vnext.w13reflect.Person";
		Class<?> clazz = Class.forName(className);
		//创建对应的运行时类的对象。使用newInstance()，实际上就是调用了运行时类的空参的构造器。
		//要想能够创建成功：1.要求对应的运行时类要有空参的构造器。2.构造器的权限修饰符的权限要足够。
		Object obj = clazz.newInstance();
		Person p = (Person)obj;
		System.out.println(p);
	}

	// 获取类的构造器,并创建对象
	@Test
	public void test2() throws ClassNotFoundException{
		String className = "com.vnext.w13reflect.Person";
		Class<?> clazz = Class.forName(className);

		@SuppressWarnings("rawtypes")
		Constructor[] cons = clazz.getDeclaredConstructors();
		for(Constructor<?> c : cons){
			System.out.println(c);
		}
	}

	//调用指定的构造器,创建运行时类的对象
	@Test
	public void test3() throws Exception{
		String className = "com.vnext.w13reflect.Person";
		Class<?> clazz = Class.forName(className);

		Constructor<?> cons = clazz.getDeclaredConstructor(String.class,int.class);
		cons.setAccessible(true);
		Person p = (Person)cons.newInstance("罗伟",20);
		System.out.println(p);
	}

}
