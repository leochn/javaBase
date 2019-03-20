package com.vnext.w19juc.juc03;

/**
 * @Auther: LEO
 * @Date: 2019/3/20 13:26
 * @Description:
 */
public class ChildThread01 implements Runnable {
    private static ChildThreadExceptionHandler exceptionHandler;

    static {
        exceptionHandler = new ChildThreadExceptionHandler();
    }

    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(exceptionHandler);
        System.out.println("do something 1");
        exceptionMethod();
        System.out.println("do something 2");
    }

    private void exceptionMethod() {
        throw new RuntimeException("ChildThread01 exception");
    }

    public static class ChildThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        }
    }
}