package com.vnext.w19juc.juc03;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Auther: LEO
 * @Date: 2019/3/20 13:29
 * @Description:
 */
public class ThreadTest01 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
//        Future future = executorService.submit(new ChildThread01());
        Future future = executorService.submit(new ChildThread02());
        try {
            Object o = future.get();

        } catch (InterruptedException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } catch (ExecutionException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

    }
}
