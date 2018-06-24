package com.vnext.w14multi.m08ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author leo
 * @version 2018/2/13 7:05
 * @since 1.0.0
 */
public class UseThreadPoolExecutor1 {

    public static void main(String[] args) {
        /**
         * 在使用有界队列时，若有新的任务需要执行，如果线程池实际线程数小于corePoolSize，则优先创建线程，
         * 若大于corePoolSize，则会将任务加入队列，
         * 若队列已满，则在总线程数不大于maximumPoolSize的前提下，创建新的线程，
         * 若线程数大于maximumPoolSize + workQueue.size，则执行拒绝策略。或其他自定义方式。
         *
         */

        /**
         *    public ThreadPoolExecutor(
         *           int corePoolSize,        //corePoolSize: 当前核心线程数
         *           int maximumPoolSize,     // maximumPoolSize:最大线程数
         *           long keepAliveTime,      // keepAliveTime:线程池里面的线程保持存活的时间
         *           TimeUnit unit,           // unit:指定keepAliveTime的时间单位
         *           BlockingQueue<Runnable> workQueue,   // workQueue: 存放任务的队列
         *           RejectedExecutionHandler handler)    // RejectedExecutionHandler:当workQueue已满,无法再存放任务时,则这些无法存放的任务走这个handler
         *     {
         *         this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
         *              Executors.defaultThreadFactory(), handler);
         *     }
         */

        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                1, 				// coreSize:当前核心线程数
                2, 			// MaxSize：最大线程数
                60, 			// 60：线程池里面的线程保持存活的时间
                TimeUnit.SECONDS,           // 指定keepAliveTime的时间单位
                new ArrayBlockingQueue<Runnable>(4)	  //指定一种队列，存放任务（有界队列）
                //new LinkedBlockingQueue<Runnable>()
                , new MyRejected()
                //, new DiscardOldestPolicy()
        );

        MyTask mt1 = new MyTask(1, "任务1");
        MyTask mt2 = new MyTask(2, "任务2");
        MyTask mt3 = new MyTask(3, "任务3");
        MyTask mt4 = new MyTask(4, "任务4");
        MyTask mt5 = new MyTask(5, "任务5");
        MyTask mt6 = new MyTask(6, "任务6");
        MyTask mt7 = new MyTask(7, "任务7");
        MyTask mt8 = new MyTask(8, "任务8");
        MyTask mt9 = new MyTask(9, "任务9");

        pool.execute(mt9);
        pool.execute(mt8);
        pool.execute(mt1);
        pool.execute(mt2);
        pool.execute(mt3);
        pool.execute(mt4);
        pool.execute(mt5);
        pool.execute(mt6);
        pool.execute(mt7);

        pool.shutdown();

    }
}
