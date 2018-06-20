/**
 * 
 */
package com.vnext.w08exception;

import org.junit.Test;

/**
 * 异常处理(try-catch-finally)
 * @author leo
 * @since 2018-02-06 15:09:23
 */
public class TestFinally {

	public static void main(String[] args) {
		int i = method1();
		System.out.println("method1输出结果：" + i);
	}

	@Test
	public void testMethod2(){
		int num = method2();
		System.out.println("method2输出结果：" + num);
	}

	@Test
	public void testMethod3(){
		int num = method3();
		System.out.println("method3输出结果：" + num);
	}
	
	public static int method1(){
		try{
			System.out.println(10/0);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 3;
		}finally{
			System.out.println("我是finally代码块！");
		}
	}

	public static int method2(){
		try{
			int a = 2;
			System.out.println(10/0);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 3;
		}finally{
			System.out.println("我是finally代码块！");
			return 2;
		}
	}

	public static int method3(){
		try{
			int a = 2;
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 3;
		}finally{
			System.out.println("我是finally代码块！");
			return 100;
		}
	}
}
