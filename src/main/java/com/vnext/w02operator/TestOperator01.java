package com.vnext.w02operator;

import org.junit.Test;

/**
 * Operator:运算符
 * 
 * @author leo
 * @since 2018-02-07 10:05:48
 */
public class TestOperator01 {
	// 运算符：就是对常量和变量进行操作的符号
	
	//	(1).运算符分类：算术运算符，赋值运算符，比较运算符，逻辑运算符，位运算符，三目运算符
	//	(2).算术运算符
	//		A: + , - , * , / , % , ++ , --
	//		B:+的用法
	//			a:加法
	//			b:正号
	//			c:字符串连接符
	//		C:/和%的区别
	//			数据做除法操作的时候，/取得是商，%取得是余数
	//		D:++和--的用法
	//			a:他们的作用是自增或者自减
	//			b:使用
	//				**单独使用
	//					放在操作数据的前面和后面效果一样。
	//					a++或者++a效果一样。
	//				**参与操作使用
	//					放在操作数的前面：先自增或者自减，再参与操作
	//						int a = 10;
	//						int b = ++a;
	//					放在操作数的后面：先参与操作，再自增或者自减
	//						int a = 10;
	//						int b = a++;
	//	(3).赋值运算符
	//		A:=,+=,-=,*=,/=,%=等
	//		B:=叫做赋值运算符，也是最基本的赋值运算符
	//			int x = 10; 把10赋值给int类型的变量x。
	//		C:扩展的赋值运算符的特点
	//			隐含了自动强制转换。
	//			面试题：
	//				short s = 1;s = s + 1;
	//				short s = 1;s += 1;
	//				请问上面的代码哪个有问题?
	//	short在内存中占2个字节，而整数1默认为int型占4个字节，s1+1其实这个时候就向上转型为int类型了，因此第一行代码必须强转才行。
	//	(4).比较运算符
	//		A:==,!=,>,>=,<,<=
	//		B:无论运算符两端简单还是复杂最终结果是boolean类型。
	//		C:千万不要把==写成了=
	//		D:>、 < 、 >= 、 <= 只支持左右两边操作数是数值类型
	//		E:== 、 != 两边的操作数既可以是数值类型，也可以是引用类型
	//	(5).逻辑运算符
	//		A:&,|,^,!,&&,||
	//		B:逻辑运算符用于连接boolean类型的式子
	//		C:结论
	//			&:有false则false
	//			|:有true则true
	//			^:相同则false，不同则true。
	//			!:非true则false，非false则true
	//			&&:结果和&是一样的，只不过有短路效果。左边是false，右边不执行。
	//			||:结果和|是一样的，只不过有短路效果。左边是true，右边不执行。
	//	(6).位运算符(了解)
	//		A:^的特殊用法
	//			一个数据针对另一个数据位异或两次，该数不变
	//		B:面试题
	//			a:请实现两个变量的交换
	//				**采用第三方变量
	//				**用位异或运算符
	//					左边a,b,a
	//					右边a^b
	//			b:请用最有效率的方式计算出2乘以8的结果
	//					2<<3
	//	(7).三元运算符
	//		A:格式
	//			比较表达式?表达式1:表达式2;
	//		B:执行流程：
	//			首先计算比较表达式的值，看是true还是false。
	//			如果是true，表达式1就是结果。
	//			如果是false，表达式2就是结果。
	//		C:案例：
	//			a:比较两个数据是否相等
	//			b:获取两个数据中的最大值
	//			c:获取三个数据中的最大值
	
	/**
	 * 1.算术运算符: + , - , * , / , % , ++ , --
	 */
	@Test
	public void test01() {
		int a = 1;
		System.out.println("a = " + a); // a = 1
		int b = a++; // 运算符,放在变量的后面：先参与操作，再自增或者自减
		// a++ ==> a = a + 1
		System.out.println("a = " + a); // a = 2
		System.out.println("b = " + b); // b = 1
		System.out.println("int b = a++ 可分解为 int b = a;  a = a+1;");

		System.out.println("************************************************");
		int c = 10;
		System.out.println("c = " + c);
		int d = ++c; // 运算符,放在变量的前面：先自增或者自减，再参与操作
		int cc = 10;
		int dd = cc++; // 运算符,放在变量的后面：先参与操作，再自增或者自减
		System.out.println("c = " + c + "; d = " + d); // c = 11 ; d = 11
		System.out.println("cc = " + cc + " ;dd = " + dd); // cc = 11 ; dd = 10
		System.out.println("int d = ++c 可分解为 c = c + 1;  int d = c;");

		// d-- ==> d = d - 1
		d--;
		System.out.println("d = " + d); // d = 10

		// 变态题
		System.out.println("****************变态题目，考优先级和运算符知识****************");
		int e = 100;
		int f = ++e + --e;
		System.out.println("f = " + f); // f = 201

		int g = 100;
		int h = g++ + --g;
		System.out.println("h = " + h); // h = 200
		System.out.println("===========================");
	}

	/**
	 * 2.赋值运算符: =,+=,-=,*=,/=,%=等
	 */
	@Test
	public void test02() {
		short s = 1;
		// short在内存中占2个字节，而整数1默认为int型占4个字节，s1+1其实这个时候就向上转型为int类型了，因此代码必须强转才行。
		s = (short) (s + 1);
		System.out.println("s=" + s);

		short d = 1;
		d += 1; // += 扩展的赋值运算符的特点,隐含了自动强制转换
		System.out.println("d=" + d);
	}

	/**
	 * 逻辑运算符 : &,|,^,!,&&,||
	 */
	@Test
	public void test05() {
		int a = 100;
		int b = 100;

		System.out.println(a > b && a > 99);
		// a大于b并且a大于99
		if (a > b && a > 99) {
			System.out.println("a > 99 and a > b");
		}

		// a大于b或者是a大于99
		System.out.println(a > b || a > 99);
		if (a > b || a > 99) {
			System.out.println("a > 99 but not a > b");
		}

		// a小于等于b
		System.out.println((a > b));
		System.out.println(!(a > b)); // !(a > b) ==> (a <= b)
		if (!(a > b)) {
			System.out.println("not a > b");
		}

		System.out.println("=============================");

		boolean aa = true;
		int i = 10;
		if (aa | (i++) > 0) {
		}
		System.out.println(i); // 输出11,即的右边有进行运算
		i = 10;
		if (aa || (i++) > 0) {
		}
		System.out.println(i); // 输出10,即的右边有进行运算

		aa = false;
		i = 10;
		if (aa && (i++) > 0) {
			System.out.println("true;i=" + i);
		} else {
			System.out.println("false;i=" + i); // false;i=10
		}
		i = 10;
		if (aa & (i++) > 0) {
			System.out.println("true;i=" + i);
		} else {
			System.out.println("false;i=" + i); // false;i=11
		}
	}

	/**
	 * 位运算符
	 */
	@Test
	public void test06() {
		int a = 129;
		int b = 128;
		System.out.println("a 和b 与的结果是：" + (a & b)); // a 和b 与的结果是：128
		// “a”的值是129，转换成二进制就是10000001，而“b”的值是128，转换成二进制就是10000000。
		// 根据与运算符的运算规律，只有两个位都是1，结果才是1，可以知道结果就是10000000，即128。

		System.out.println("a 和b 或的结果是：" + (a | b)); // a 和b 或的结果是：129
		// a 的值是129，转换成二进制就是10000001，而b 的值是128，转换成二进制就是10000000，
		// 根据或运算符的运算规律，只有两个位有一个是1，结果才是1，可以知道结果就是10000001，即129。

		a = 2; // 0010 --> 1101
		System.out.println("a 非的结果是：" + (~a)); // a 非的结果是：-3
		// 如果位为0，结果是1，如果位为1，结果是0

		a = 15;
		b = 2;
		System.out.println("a 与 b 异或的结果是：" + (a ^ b)); // a 与 b 异或的结果是：13
		// 分析上面的程序段：a 的值是15，转换成二进制为1111，而b 的值是2，转换成二进制为0010，根据异或的运算规律，可以得出其结果为1101 即13
		
		a = 2;  // 0010 --> 1000
		System.out.println("a 左移2位的结果是：" + (a << 2)); // a 左移2位的结果是：8
		// 左移运算符，将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）
		
		a = 5;  // 0101 --> 0000
		System.out.println("a 右移3位的结果是：" + (a >> 3)); // a 右移3位的结果是：0
		a = -5; // 0101 --> 0000
		System.out.println("a 右移3位的结果是：" + (a >> 3)); // a 右移3位的结果是：-1
		// "有符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。
		// 使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.
	}
	
	// 两种变量的交换
	@Test
	public void test07() {
		// 1. 第三个变量交换数值
		int x = 5, y = 10;
		int temp = x;
		x = y;
		y = temp;
		System.out.println("x=" + x + "  ;y=" + y);
		// 2.用两个数求和然后相减的方式进行数据交换,弊端在于如果 x 和 y 的数值过大的话，超出 int 的值会损失精度
		x = 5; y = 10;
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("x=" + x + "  ;y=" + y);
		// 3.利用位运算的方式进行数据的交换，利用的思想原理是：一个数异或同一个数两次，结果还是那个数，而且不会超出int范围
		x = 5; y = 10;
		x = x^y;
		y = x^y;
		x = x^y;
		System.out.println("x=" + x + "  ;y=" + y);
		int a = 10;
		long startTime = System.nanoTime();
		a = 2 << 8;
		// 2 << 3，因为将一个数左移n 位，就相当于乘以了2的n 次方，那么，一个数乘以8只要将其左移3位
		// 即可，而位运算 cpu 直接支持的，效率最高，所以，2乘以8等於几的最效率的方法是2 << 3
		long endTime = System.nanoTime();
		System.out.println("a=" + a + ";花费的时间:"+ (endTime - startTime));
		startTime = System.nanoTime();
		a = 2 * 256;
		endTime = System.nanoTime();
		System.out.println("a=" + a + ";花费的时间:"+ (endTime - startTime));
	}
	
	@Test
	public void test08() {
		int a = 10;
		long startTime = System.nanoTime();
		a = 2 << 8;
		// 2 << 3，因为将一个数左移n 位，就相当于乘以了2的n 次方，那么，一个数乘以8只要将其左移3位
		// 即可，而位运算 cpu 直接支持的，效率最高，所以，2乘以8等於几的最效率的方法是2 << 3
		long endTime = System.nanoTime();
		System.out.println("a=" + a + ";花费的时间:"+ (endTime - startTime));
		startTime = System.nanoTime();
		a = 2 * 256;
		endTime = System.nanoTime();
		System.out.println("a=" + a + ";花费的时间:"+ (endTime - startTime));
	}

}
