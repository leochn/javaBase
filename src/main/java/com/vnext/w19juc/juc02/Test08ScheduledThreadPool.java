package com.vnext.w19juc.juc02;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author leo
 * @since 2018/3/28 12:41
 */
public class Test08ScheduledThreadPool {

    public static void main(String[] args) throws Exception {

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Future<Integer> result = pool.schedule(new Callable<Integer>(){

                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);//生成随机数
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    return num;
                }

            }, 1, TimeUnit.SECONDS);

            System.out.println(result.get());
        }

        pool.shutdown();
    }
}
