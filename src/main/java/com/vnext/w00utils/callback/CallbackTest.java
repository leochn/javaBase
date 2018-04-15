package com.vnext.w00utils.callback;

/**
 * @author leo
 * @version 2018/4/15 9:52
 * @since 1.0.0
 */
public class CallbackTest {

    /**
     Class A实现接口CallBack callback——背景1
     class A中包含一个class B的引用b ——背景2
     class B有一个参数为callback的方法f(CallBack callback) ——背景3
     A的对象a调用B的方法 f(CallBack callback) ——A类调用B类的某个方法 C
     然后b就可以在f(CallBack callback)方法中调用A的方法 ——B类调用A类的某个方法D
     */

    public static void main(String[]args){
        /**
         * new 一个小李
         */
        Li li = new Li();

        /**
         * new 一个小王
         */
        Wang wang = new Wang(li);

        /**
         * 小王问小李问题
         */
        wang.askQuestion("1 + 1 = ?");
    }
}
