/**
 * 
 */
package com.vnext.exception;

/**
 * 异常处理(try-catch-finally)
 * @author leo
 * @since 2018-02-06 14:04:29
 */
public class TestException {

	public static void main(String[] args) {
		TestException exceptionTest = new TestException();
		int num = exceptionTest.getNum();
		System.out.println("num = " + num);
		System.out.println("-----------------------");
		System.out.println("number = " + exceptionTest.getNumber());
	}

	public int getNum() {
		try {
			int a = 1 / 0;
			System.out.println("a=" + a);
			return 1;
		} catch (Exception e) {
			System.out.println("catch..........");
			return 2;
		} finally {
			int b = 1/1;
			System.out.println("b=" + b);
			//return 3;
		}
	}
	
	@SuppressWarnings("finally")
	public int getNumber() {
		try {
			int a = 1 / 0;
			System.out.println("a=" + a);
			return 1;
		} catch (Exception e) {
			System.out.println("catch..........");
			return 2;
		} finally {
			int b = 1/1;
			System.out.println("b=" + b);
			return 3;
		}
	}
}
/*catch..........
b=1
num = 2
-----------------------
catch..........
b=1
number = 3*/


/* getNum():
 * 代码在走到第 23 行的时候遇到了一个 MathException，这时第24行的代码就不会执行了，
 * 代码直接跳转到catch 语句中，走到第 28 行的时候，异常机制有这么一个原则如果在 catch 中遇到了 return 或者异常等能使该函数终止的话,
 * 那么用 finally 就必须先执行完 finally 代码块里面的代码，然后再返回值。
 * 因此代码又跳到第30行往下执行，finally 仅仅是处理了一个释放资源的操作，到31行代码后，又返回到第28行代码，执行return操作，
 * 因此最终返回的结果就是 2。
 * */


/* getNumber():
 * 代码在走到第 39 行的时候遇到了一个 MathException，这时第40行的代码就不会执行了，
 * 代码直接跳转到catch 语句中，走到第 44 行的时候，
 * 异常机制有这么一个原则如果在 catch 中遇到了 return 或者异常等能使该函数终止的话,
 * 那么用 finally 就必须先执行完 finally 代码块里面的代码，然后再返回值。
 * 因此代码又跳到第46行往下执行，可惜第 48 行是一个 return 语句，那么这个时候方法就结束了，
 * 因此第 44 行的返回结果就无法被真正返回。而是在第48行就返回了3这个值。
 * */

