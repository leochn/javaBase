package com.vnext.w17jvm.stack;

/**
 * 测试 java.lang.StackOverflowError
 * @author leo
 * @version 2018/3/1 21:34
 * @since 1.0.0
 */
public class StackDemo {

    // 测试 java.lang.StackOverflowError

    public static void main(String[] args) {
        sayHello();
    }

    private static void sayHello() {
        sayHello();
    }

}
