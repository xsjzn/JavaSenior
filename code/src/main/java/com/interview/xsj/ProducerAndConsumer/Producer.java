package com.interview.xsj.ProducerAndConsumer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author xsj
 * @create 2021-05-22 9:47
 */
public class Producer {
    int MAX_SIZE=100;
    public Object object;
    public Deque<Integer> deque;
    public Producer(Object object, ArrayDeque<Integer> deque){
        this.object=object;
        this.deque=deque;
    }

    public void produce(){
        synchronized (object) {
            /*只有list为空时才会去进行生产操作*/
            try {
                while(deque.size()==MAX_SIZE){
                    System.out.println("生产者"+Thread.currentThread().getName()+" waiting");
                    object.wait();
                }
                int value = 9999;
                deque.addFirst(value);
                System.out.println("生产者"+Thread.currentThread().getName()+" Runnable");
                object.notifyAll();//然后去唤醒因object调用wait方法处于阻塞状态的线程
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
