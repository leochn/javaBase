/**
 * 
 */
package com.vnext.exception;

/**
 * 异常处理(try-catch-finally)
 * @author leo
 * @since 2018-02-06 15:09:23
 */
public class TestFinally {

	public static void main(String[] args) {
		int i = method1();
		System.out.println(i);
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
			//return 2;
		}
	}
}
