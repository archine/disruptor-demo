package com.aj.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author Gjing
 **/
class EventProducer {
    private RingBuffer<LongEvent> ringBuffer;

    EventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR
            = (event, sequence, byteBuffer) -> event.set(byteBuffer.getLong(0));

    void sendData(ByteBuffer data) {
        //发布消息
        ringBuffer.publishEvent(TRANSLATOR, data);
    }
}
