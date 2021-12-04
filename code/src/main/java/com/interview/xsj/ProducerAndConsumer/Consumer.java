package com.interview.xsj.ProducerAndConsumer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xsj
 * @create 2021-05-22 9:30
 */
public class Consumer  {
    public Object object;
    public Deque<Integer> deque;
    public Consumer(Object object, ArrayDeque<Integer> deque){
        this.object=object;
        this.deque=deque;
    }

    public void consume(){
        synchronized (object){
            try {
                while (deque.isEmpty()){//队列不空的时候才消费，不然就等着
                    System.out.println("消费者"+Thread.currentThread().getName()+"正在等待");
                    object.wait();
                }
                deque.pollLast();//当然也可以该位用队列pop出来一个
                System.out.println("消费者"+Thread.currentThread().getName()+" Runnable");
                object.notifyAll();//然后去唤醒因object调用wait方法处于阻塞状态的线程

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
