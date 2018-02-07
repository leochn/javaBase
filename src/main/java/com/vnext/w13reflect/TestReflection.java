package com.vnext.w13reflect;

import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflection {

	@Test
	public void test1() {
		// 在反射以前，创建一个类对象，并调用其中的方法、属性
		Person p = new Person();
		p.setAge(10);
		p.setName("TangWei");
		System.out.println(p);
		p.show();
	}
	
    //有了反射，可以通过反射创建一个类的对象，并调用其中的结构
	@Test
	public void test2() throws Exception{
		//Class<Person> w04object = Person.class;
		Class<?> clazz = Person.class;
		
		//1.创建clazz对应的运行时类Person类的对象
		Person p = (Person)clazz.newInstance();
		System.out.println(p);
		
		//2.通过反射调用运行时类的指定的属性
		//2.1
		Field f1 = clazz.getField("name");
		f1.set(p,"LiuDeHua");
		System.out.println(p);
		//2.2
		Field f2 = clazz.getDeclaredField("age");
		f2.setAccessible(true); // 设置修改私有属性
		f2.set(p, 20);
		System.out.println(p);
		
		//3.通过反射调用运行时类的指定的方法
		Method m1 = clazz.getMethod("show");
		m1.invoke(p);
		
		Method m2 = clazz.getMethod("display",String.class,Integer.class);
		m2.invoke(p,"CHN",10);
		
		// 方法有几个参数,就传入几个参数
		Method m3 = clazz.getMethod("say", String.class, Integer.class);
		m3.invoke(p, "helloWorld" , 100);
	}
	
	/*
	 * java.lang.Class:是反射的源头。
	 * 我们创建了一个类，通过编译（javac.exe）,生成对应的.class文件。之后我们使用java.exe加载（JVM的类加载器完成的）
	 * 此.class文件，此.class文件加载到内存以后，就是一个运行时类，存在在缓存区。那么这个运行时类本身就是一个Class的实例！
	 * 1.每一个运行时类只加载一次！
	 * 2.有了Class的实例以后，我们才可以进行如下的操作：
	 *     1）*创建对应的运行时类的对象
	 *     2）获取对应的运行时类的完整结构（属性、方法、构造器、内部类、父类、所在的包、异常、注解、...）
	 *     3）*调用对应的运行时类的指定的结构(属性、方法、构造器)
	 *     4）反射的应用：动态代理
	 */
	@Test
	public void test3(){
		Person p = new Person();
		Class<? extends Person> clazz = p.getClass();//通过运行时类的对象，调用其getClass()，返回其运行时类。
		System.out.println(clazz);
	}
	
	//如何获取Class的实例（3种）
	@Test
	public void test4() throws Exception{
		//1.调用运行时类本身的.class属性
		Class<Person> clazz1 = Person.class;
		System.out.println("clazz1 = " + clazz1.getName());
		
		Method method = clazz1.getMethod("say", String.class, Integer.class);
		Person person = clazz1.newInstance();
		method.invoke(person, "CHN",10);
		
		Class<String> clazz2 = String.class;
		System.out.println("clazz2 = " + clazz2.getName());
		
		//2.通过运行时类的对象获取
		Person p = new Person();
		Class<? extends Person> clazz3 = p.getClass();
		System.out.println("clazz3 = " + clazz3.getName());
		
		//3.通过Class的静态方法获取.通过此方式，体会一下，反射的动态性。
		String className = "com.vnext.w13reflect.Person";
		
		
		Class<?> clazz4 = Class.forName(className);
		//	clazz4.newInstance();
		System.out.println("clazz4 = " + clazz4.getName());
		
		//4.（了解）通过类的加载器
		ClassLoader classLoader = this.getClass().getClassLoader();
		Class<?> clazz5 = classLoader.loadClass(className);
		System.out.println("clazz5 = " + clazz5.getName());
		
		System.out.println(clazz1 == clazz3);//true
		System.out.println(clazz1 == clazz4);//true
		System.out.println(clazz1 == clazz5);//true
	}
	
	//关于类的加载器：ClassLoader
	@Test
	public void test5() throws Exception{
		ClassLoader loader1 = ClassLoader.getSystemClassLoader();
		System.out.println(loader1); // sun.misc.Launcher$AppClassLoader@816f27d
		
		ClassLoader loader2 = loader1.getParent();
		System.out.println(loader2); // sun.misc.Launcher$ExtClassLoader@58372a00
		
		ClassLoader loader3 = loader2.getParent();
		System.out.println(loader3); // null
		
		Class<?> clazz1 = Person.class;
		ClassLoader loader4 = clazz1.getClassLoader();
		System.out.println(loader4); // sun.misc.Launcher$AppClassLoader@816f27d
		
		String className = "java.lang.String";
		Class<?> clazz2 = Class.forName(className);
		ClassLoader loader5 = clazz2.getClassLoader();
		System.out.println(loader5); // null
		
		//掌握如下
		ClassLoader loader = this.getClass().getClassLoader();
		InputStream is = loader.getResourceAsStream("com\\\\vnext\\\\w13reflect\\\\jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);
		String name = pros.getProperty("user");
		System.out.println(name);
		
		String password = pros.getProperty("password");
		System.out.println(password);
	}
}
// The last packet successfully received from the server was 33,315,876 milliseconds ago.  The last packet sent successfully to the server was 12 milliseconds ago
