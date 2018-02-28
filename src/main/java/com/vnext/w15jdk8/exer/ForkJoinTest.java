package com.vnext.w15jdk8.exer;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author leo
 * @version 2018/2/28 20:29
 * @since 1.0.0
 */
public class ForkJoinTest {

    @Test
    public void test1(){
        Instant start = Instant.now();
        long sum = 0L;
        for (long i = 0L; i <= 50000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间为: " + Duration.between(start,end).toMillis());
    }

    @Test
    public void test2(){
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 50000000000L);
        long sum = pool.invoke(task);

        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费的时间为: " + Duration.between(start,end).toMillis());
    }

    /**
     * jdk8 并行流
     */
    @Test
    public void test3(){
        Instant start = Instant.now();
        Long sum = LongStream.rangeClosed(0L, 50000000000L)
                .parallel()
                .sum();

        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费的时间为: " + Duration.between(start,end).toMillis());
    }

}
