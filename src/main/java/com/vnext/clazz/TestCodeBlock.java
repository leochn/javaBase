/**
 * 
 */
package com.vnext.clazz;

/**
 * 代码块测试：java对象初始化过程
 * @author leo
 * @since 2018-02-06 18:29:13
 */
public class TestCodeBlock {
	public static void main(String[] args) {
		CodeBlock codeBlock = new CodeBlock();
		System.out.println(codeBlock);
		// 局部代码块
		{
			int x = 10;
			System.out.println("局部代码块1：" + x);
		}
		System.out.println("演示1---------------");
		new CodeBlock();
		System.out.println("演示2---------------");
		new CodeBlock();
		System.out.println("演示3---------------");
		new CodeBlock(1);
		System.out.println("演示4---------------");
		new CodeBlockSon();
		{
			int y = 20;
			System.out.println("局部代码块2：" + y);
		}
	}
}

class CodeBlockSon extends CodeBlockFather{
	// 静态代码块
	static {
		int b = 2000;
		System.out.println("CodeBlockSon,静态代码块：" + b);
	}
	// 构造方法
	public CodeBlockSon() {
		System.out.println("CodeBlockSon,无参构造方法");
	}
	// 构造代码块
	{
		int y = 200;
		System.out.println("CodeBlockSon,构造代码块2：" + y);
	}
}
class CodeBlock {
	public static int count = 200;
	public static String str = "str";
	// 静态代码块
	static {
		int b = 2000;
		System.out.println("CodeBlock,静态代码块2：" + b);
	}
	// 构造代码块
	{
		int x = 100;
		System.out.println("CodeBlock,构造代码块1：" + x);
	}
	// 构造方法
	public CodeBlock() {
		System.out.println("CodeBlock,无参构造方法");
	}
	// 构造方法
	public CodeBlock(int a) {
		System.out.println("CodeBlock,有参构造方法,a =" + a);
	}
	// 构造代码块
	{
		int y = 200;
		System.out.println("CodeBlock,构造代码块2：" + y);
	}
	// 静态代码块
	static {
		int a = 1000;
		System.out.println("CodeBlock,静态代码块1：" + a);
	}
}

class CodeBlockFather{
	public CodeBlockFather(){
		System.out.println("CodeBlockFather,无参构造函数");
	}
	public CodeBlockFather(int f){
		System.out.println("CodeBlockFather,无参构造函数,f=" + f);
	}
	// 静态代码块
	static {
		int a = 1000;
		System.out.println("CodeBlockFather,静态代码块1：" + a);
	}
	// 构造代码块
	{
		int y = 200;
		System.out.println("CodeBlockFather,构造代码块2：" + y);
	}
	
	

}

/*
局部代码块1：10             ==>局部代码块只是简单的顺序执行程序，与实际位置有关
演示1---------------
CodeBlock,静态代码块2：2000 ==> 静态代码块只是在该类第一次创建对象的时候才会被调用，而且初始化顺序与代码所在具体位置无关
CodeBlock,静态代码块1：1000
CodeBlock,构造代码块1：100  ==>构造代码块在每次初始化对象的时候都会被调用，而且初始化顺序与代码所在具体位置无关
CodeBlock,构造代码块2：200
CodeBlock,无参构造方法

演示2---------------
CodeBlock,构造代码块1：100  ==>构造代码块在每次初始化对象的时候都会被调用，而且初始化顺序与代码所在具体位置无关
CodeBlock,构造代码块2：200
CodeBlock,无参构造方法
演示3---------------
CodeBlock,构造代码块1：100  ==>构造代码块在每次初始化对象的时候都会被调用，而且初始化顺序与代码所在具体位置无关
CodeBlock,构造代码块2：200
CodeBlock,有参构造方法,a =1
演示4---------------
CodeBlockFather,静态代码块1：1000
CodeBlockSon,静态代码块：2000
CodeBlockFather,构造代码块2：200
CodeBlockFather,无参构造函数
CodeBlockSon,构造代码块2：200
CodeBlockSon,无参构造方法
局部代码块2：20
*/
