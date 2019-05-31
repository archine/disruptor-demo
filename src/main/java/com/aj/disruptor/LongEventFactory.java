package com.aj.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author Gjing
 * 事件工厂类
 **/
public class LongEventFactory implements EventFactory<LongEvent> {
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
