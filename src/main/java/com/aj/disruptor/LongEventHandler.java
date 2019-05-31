package com.aj.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author Gjing
 * 事件处理类
 **/
public class LongEventHandler implements EventHandler<LongEvent> {
    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) {
        System.out.println("Event: " + longEvent.toString());
    }
}
