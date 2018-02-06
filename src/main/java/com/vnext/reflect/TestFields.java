package com.vnext.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class TestFields {

	@Test
	public void test1() {
		Class<Person> clazz = Person.class;
		//1.getFields():只能获取到运行时类中及其父类中声明为public的属性
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		System.out.println("----------------------");
		
		//2.getDeclaredFields():获取运行时类本身声明的所有的属性
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			System.out.println(f.getName());
		}
	}
	
	//权限修饰符  变量类型 变量名
	//获取属性的各个部分的内容
	@Test
	public void test2(){
		Class<Person> clazz = Person.class;
		Field[] fields1 = clazz.getDeclaredFields();
		for(Field f : fields1){
			//1.获取每个属性的权限修饰符
			int i = f.getModifiers();
			System.out.println("i = " + i);
			// 转义为 private 等修饰符
			String str1 = Modifier.toString(i);
			System.out.println("权限修饰符:" + str1);
			//2.获取属性的类型
			Class<?> type = f.getType();
			System.out.println("属性的类型:" + type.getName());
			//3.获取属性名
			System.out.println("属性的名字:" +f.getName());
			System.out.println("-------");
		}
	}

	// 调用运行时类中指定的属性
	@Test
	public void test3() throws Exception {
		Class<Person> clazz = Person.class;
        //1.获取指定的属性
        //getField(String fieldName):获取运行时类中声明为public的指定属性名为fieldName的属性
		Field name = clazz.getField("name");
        //2.创建运行时类的对象
		Person person = clazz.newInstance();
		System.out.println(person);
        //3.将运行时类的指定的属性赋值
        name.set(person,"Jerry");
        System.out.println(person);
        System.out.println("%"+name.get(person));
        System.out.println("----");

		//getDeclaredField(String fieldName):获取运行时类中指定的名为fieldName的属性
		Field age = clazz.getDeclaredField("age");
		//由于属性权限修饰符的限制，为了保证可以给属性赋值，需要在操作前使得此属性可被操作。
		age.setAccessible(true);
		age.set(person,10);
		System.out.println(person);

	}
}
