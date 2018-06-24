package com.vnext.w14multi.m11disruptor.eg01base;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-24 07:30:29
 */
public class LongEventMain {

    public static void main(String[] args) throws Exception {
        //创建缓冲池
        ExecutorService executor = Executors.newCachedThreadPool();
        //创建工厂
        LongEventFactory factory = new LongEventFactory();
        //创建bufferSize ,也就是RingBuffer大小，必须是2的N次方
        int ringBufferSize = 1024 * 1024; //

        /**
         //BlockingWaitStrategy 是最低效的策略，但其对CPU的消耗最小并且在各种不同部署环境中能提供更加一致的性能表现
         WaitStrategy BLOCKING_WAIT = new BlockingWaitStrategy();
         //SleepingWaitStrategy 的性能表现跟BlockingWaitStrategy差不多，对CPU的消耗也类似，但其对生产者线程的影响最小，适合用于异步日志类似的场景
         WaitStrategy SLEEPING_WAIT = new SleepingWaitStrategy();
         //YieldingWaitStrategy 的性能是最好的，适合用于低延迟的系统。在要求极高性能且事件处理线数小于CPU逻辑核心数的场景中，推荐使用此策略；例如，CPU开启超线程的特性
         WaitStrategy YIELDING_WAIT = new YieldingWaitStrategy();
         */

        //创建disruptor
        Disruptor<LongEvent> disruptor =
                new Disruptor<LongEvent>(factory, ringBufferSize, executor, ProducerType.SINGLE, new YieldingWaitStrategy());
        // 连接消费事件方法
        disruptor.handleEventsWith(new LongEventHandler());

        // 启动
        disruptor.start();

        //Disruptor 的事件发布过程是一个两阶段提交的过程：
        //发布事件(使用该方法获得具体存放数据的容器ringBuffer，环形结构)
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);
        //LongEventProducerWithTranslator producer = new LongEventProducerWithTranslator(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for(long a = 0; a<100; a++){
            byteBuffer.putLong(0, a);
            producer.onData(byteBuffer);
            //Thread.sleep(1000);
        }


        disruptor.shutdown();//关闭 disruptor，方法会堵塞，直至所有的事件都得到处理；
        executor.shutdown();//关闭 disruptor 使用的线程池；如果需要的话，必须手动关闭， disruptor 在 shutdown 时不会自动关闭；
    }

}