package com.vnext.w14multi.m11disruptor.eg01base;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-24 07:34:16
 */
public class LongEventProducerWithTranslator {

    //一个translator可以看做一个事件初始化器，publicEvent方法会调用它
    //填充Event
    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                @Override
                public void translateTo(LongEvent event, long sequeue, ByteBuffer buffer) {
                    event.setValue(buffer.getLong(0));
                }
            };

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer buffer){
        ringBuffer.publishEvent(TRANSLATOR, buffer);
    }
}