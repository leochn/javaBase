package com.vnext.w14multi.m09provider;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author leo
 * @since 2018/2/12 15:11
 */
public class Provider implements Runnable{
    // 存放产品，公共缓存区
    private BlockingQueue<Data> quene;
    // 多线程间是否启动变量，有强制从主内存中刷新的功能。即时返回线程的状态。
    private volatile boolean isRunning = true;

    private static AtomicInteger count = new AtomicInteger();

    private static Random r = new Random();

    public Provider(BlockingQueue<Data> quene) {
        this.quene = quene;
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                // 随机休眠1-1000，表示获取数据的时间
                Thread.sleep(r.nextInt(500));
                int id = count.incrementAndGet();
                Data data = new Data(Integer.toString(id), "数据" + id);
                System.out.println("线程" + Thread.currentThread().getName() +",获取数据,id="+ id  + ",装载到公共缓冲区quene");
                if (!this.quene.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("提交到缓存失败...");
                    // do something.... 比如重新提交数据...
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop (){
        this.isRunning = false;
    }
}
