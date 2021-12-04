package com.interview.xsj.ProducerAndConsumer;

import java.util.ArrayDeque;

/**
 * @author xsj
 * @create 2021-05-22 9:55
 */
public class Main {
    public static void main(String[] args) {
        Object object = new Object();
        ArrayDeque<Integer> deque=new ArrayDeque<>();
        Producer p=new Producer(object,deque);
        Consumer c=new Consumer(object,deque);
        ProduceThread[] pt = new ProduceThread[2];
        ConsumeThread[] ct = new ConsumeThread[2];

        for(int i=0;i<2;i++){
            pt[i] = new ProduceThread(p);
            pt[i].setName("生产者 "+(i+1));
            ct[i] = new ConsumeThread(c);
            ct[i].setName("消费者"+(i+1));
            pt[i].start();
            ct[i].start();
        }

    }
}
