package com.vnext.w14multi.provider;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author leo
 * @since 2018/2/12 15:12
 */
public class Consumer implements Runnable{
    private BlockingQueue<Data> queue;
    private static Random r = new Random();

    public Consumer(BlockingQueue<Data> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Data data = this.queue.take();
                Thread.sleep(r.nextInt(500));
                System.out.println("线程" + Thread.currentThread().getName() + "消费成功,数据为id=" + data.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
