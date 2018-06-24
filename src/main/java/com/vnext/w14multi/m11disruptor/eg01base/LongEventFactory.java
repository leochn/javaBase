package com.vnext.w14multi.m11disruptor.eg01base;

import com.lmax.disruptor.EventFactory;

/**
 * @author leo
 * @version 1.0.0
 * @date 2018-06-24 07:25:47
 */
public class LongEventFactory implements EventFactory {

    // 需要让disruptor为我们创建事件，我们同时还声明了一个EventFactory来实例化Event对象。

    @Override
    public Object newInstance() {
        return new LongEvent();
    }
}