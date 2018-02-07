/**
 * 
 */
package com.vnext.w01datatype;

import org.junit.Test;

/**
 * 功能：java基本数据类型介绍
 * 基本数据类型：
 *      |--整数类型 byte(1个字节) short(2个字节) int(4个字节) long(8个字节)
 *      |--小数（浮点）类型  float double
 *      |--布尔类型 boolean(true/false)
 *      |--字符类型 char 两个字节
 * 注意：String不是基本数据类型，而是类
 * @author leo
 * @since 2018-02-07 09:57:08
 */
public class BasicDataTypes {
	
/*	(1). Java是一种强类型语言，针对每种数据都提供了对应的数据类型。
	(2). 分类：
			A:基本数据类型：4类8种
			B:引用数据类型：类，接口，数组。
	(3). 基本数据类型:4类8种
			A:整数类型			占用字节数               表数范围
				byte			1字节=8bit        -128 ~ 127
				short		    2                 -215 ~215-1 
				int 			4                 -231 ~ 231-1
				long			8                 -263 ~ 263-1
			B:浮点数类型
				float			4
				double		    8
			C:字符型
				char			2
			D:布尔型
				boolean		    1
			注意：
				整数默认是int类型，浮点数默认是double。
				长整型后缀用L或者l标记。建议使用L。
				单精度浮点数用F或者f标记。建议使用F。
	boolean类型数据只允许取值true和false,不可以0或非 0 的整数替代false和true。
	(4). 引用数据类型
	类class, 接口interface, 数组[]
*/

	public static void main(String[] args) {
        byte bt = 127;
        System.out.println(bt);

        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println("c = " + c);

        boolean flag = true;
        System.out.println("flag = " + flag);
        flag = false;
        System.out.println("flag now = " + flag);

        char c1 = '中';
        System.out.println(c1);
    }
	
	// 自动类型转换
	@Test
	public void test01(){
	    //String str1 = 4;           //判断对错：错
		String str2 = 3.5f + "";     //判断str2对错：对
		System.out.println(str2);    //输出：3.5
		System.out.println(3 + 4 + "Hello");   // 输出：7Hello
		System.out.println("Hello" + 3 + 4);   // 输出：Hello34
		System.out.println('a' + 1 + "Hello"); // 输出：98Hello
		System.out.println("Hello" + 'a' + 1); // 输出：Helloa1
		//当把任何基本类型的值和字符串值进行连接运算时(+),基本类型的值将自动转化为字符串类型.
		//字符在前,运算在后则不运算,直接与连接.
		//字符在后,运算在前,则运算后与字符连接.
	}
	
	@Test
	public void test02String() {
		// String类是一个典型的不可变类，String对象创建出来就不可能被改变。
		// 创建出的字符串将存放在数据区，保证每个字符串常量只有一个，不会产生多个副本
		String s0 = "hello";
		String s1 = "hello";
		String s2 = "he" + "llo";
		System.out.println(s0 == s1);  //true
		System.out.println(s0 == s2);  //true
		String s3 = new String("hello");
		System.out.println(s0 == s3);  //false
	}

}
