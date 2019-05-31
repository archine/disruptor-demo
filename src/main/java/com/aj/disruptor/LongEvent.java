package com.aj.disruptor;

/**
 * @author Gjing
 * 事件类
 **/
class LongEvent {
    private long value;

    void set(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LongEvent{" +
                "value=" + value +
                '}';
    }
}
