package com.vnext.w13reflect;

/**
 * 
 * @author leo
 * @date 2018-01-26 19:52:26
 */
@MyAnnotation(value = "helloAnnotation")
public class Person extends Creature<String> implements Comparable<Object>,MyInterface{

	private static final long serialVersionUID = 1L;
	public String name;
	private int age;
	int id;
	//创建类时，尽量保留一个空参的构造器。
	public Person() {
		super();
        // System.out.println("今天天气很闷热");
	}
	public Person(String name) {
		super();
		this.name = name;
	}

	@SuppressWarnings("unused")
	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@MyAnnotation(value = "MyAnntation----Person.show")
	public void show(){
		System.out.println("我是一个人！");
	}
	
	public Integer display(String nation,	Integer i) throws Exception{
		System.out.println("我的国籍是：" + nation + " ,i=" + i);
		return i;
	}

	public static void info(){
		System.out.println("中国人！");
	}
	
	public void say(String str,Integer num) {
		System.out.println("str=" + str + " ;num =" + num);
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
