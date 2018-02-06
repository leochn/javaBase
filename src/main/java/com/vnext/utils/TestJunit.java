/**
 * 
 */
package com.vnext.utils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author leo
 * @since 2018-02-06 18:00:49
 */
public class TestJunit {

	/*
	JUnit4使用Java5中的注解（annotation），以下是JUnit4常用的几个annotation： 
	@Before：初始化方法   对于每一个测试方法都要执行一次（注意与BeforeClass区别，后者是对于所有方法执行一次）
	@After：释放资源  对于每一个测试方法都要执行一次（注意与AfterClass区别，后者是对于所有方法执行一次）
	@Test：测试方法，在这里可以测试期望异常和超时时间 
	@Test(expected=ArithmeticException.class)检查被测方法是否抛出ArithmeticException异常 
	@Ignore：忽略的测试方法 
	@BeforeClass：针对所有测试，只执行一次，且必须为static void 
	@AfterClass：针对所有测试，只执行一次，且必须为static void 
	一个JUnit4的单元测试用例执行顺序为： 
	@BeforeClass -> @Before -> @Test -> @After -> @AfterClass; 
	每一个测试方法的调用顺序为： 
	@Before -> @Test -> @After;
	*/
	
	
	@Before
	public void before() {
		System.out.println("@Before...");
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass...");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}

	@After
	public void after() {
		System.out.println("@After");
	}

	@Test
	public void test01() {
		System.out.println("TEST01...");
	}

	@Test
	public void test() {
		System.out.println("@Test");
		assertEquals(5 + 5, 10);
	}

	@Ignore
	@Test
	public void testIgnore() {
		System.out.println("@Ignore");
	}

	@Test(timeout = 50)
	public void testTimeout() {
		System.out.println("@Test(timeout = 50)");
		assertEquals(5 + 5, 10);
	}

	@Test(expected = ArithmeticException.class)
	public void testExpected() {
		System.out.println("@Test(expected = Exception.class)");
		throw new ArithmeticException();
	}
}

