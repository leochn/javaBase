package com.vnext.w23sourcecode.A01jdbcs;

/**
 *
 * @Auther: LEO
 * @Date: 2019/1/20 07:37
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        ThreadConnection threadConnection = new ThreadConnection();
        for (int i = 1; i < 3; i++) {
            Thread thread = new Thread(threadConnection, "线程" + i);
            thread.start();
        }
    }

}
