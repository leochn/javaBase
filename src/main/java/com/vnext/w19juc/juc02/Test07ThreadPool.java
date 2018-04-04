package com.vnext.w19juc.juc02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author leo
 * @since 2018/3/28 12:38
 */
public class Test07ThreadPool {

    public static void main(String[] args) throws Exception {
        //1. 创建线程池
        ExecutorService pool = Executors.newFixedThreadPool(5);

        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            // 2. 为线程池中的线程分配任务
            Future<Integer> future = pool.submit(new Callable<Integer>() {

                @Override
                public Integer call() throws Exception {
                    int sum = 0;

                    for (int i = 0; i <= 100; i++) {
                        sum += i;
                    }
                    return sum;
                }

            });

            list.add(future);
        }

        //3. 关闭线程池
        pool.shutdown();

        for (Future<Integer> future : list) {
            System.out.println(future.get());
        }
    }
}
