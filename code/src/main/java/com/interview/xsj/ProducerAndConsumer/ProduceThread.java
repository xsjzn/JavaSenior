package com.interview.xsj.ProducerAndConsumer;

/**
 * @author xsj
 * @create 2021-05-22 9:53
 */
public class ProduceThread extends Thread {
    private Producer producer;
    public ProduceThread(Producer p){
        producer = p;
    }
    @Override
    public void run() {
        producer.produce();
    }
}
