package com.aj.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;

import java.nio.ByteBuffer;

/**
 * @author Gjing
 **/
public class Test {

    public static void main(String[] args) {
        int bufferSize = 1024;
        //构造Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEvent::new, bufferSize,
                DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());
        //添加消费者的监听
        disruptor.handleEventsWith(new LongEventHandler());
        //开启disruptor的所有线程
        disruptor.start();
       //获取实际存取数据的容器
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        EventProducer producer = new EventProducer(ringBuffer);

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0, i);
            producer.sendData(byteBuffer);
        }
        disruptor.shutdown();
    }
}
