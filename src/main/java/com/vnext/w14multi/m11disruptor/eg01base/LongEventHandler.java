package com.vnext.w14multi.m11disruptor.eg01base;

import com.lmax.disruptor.EventHandler;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-24 07:28:57
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    //我们还需要一个事件消费者，也就是一个事件处理器。这个事件处理器简单地把事件中存储的数据打印到终端：

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println(longEvent.getValue());
    }
}