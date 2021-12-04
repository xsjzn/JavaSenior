package com.interview.xsj.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**ArrayBlockingQueue基于数组的阻塞队列，生产者消费者模型应用。
 * lock是一把全局锁
 * @author xsj
 * @create 2021-04-28 20:30
 */
public class XsjArrayBlockingQueue<E> {
    private Object[] table;
    private int capacity;
    int count=0;
    private int putIndex=0;
    private int takeIndex =0;
    private Lock lock;
    private Condition notFull;//写条件
    private Condition notEmpty;//读条件

    public XsjArrayBlockingQueue(int capacity) {
        this.capacity = capacity;
        table=new Object[capacity];
        lock=new ReentrantLock();
        notFull=lock.newCondition();
        notEmpty=lock.newCondition();
    }
    public void put(E e) throws InterruptedException {
        if(e==null){
            throw new NullPointerException();
        }
        try {
            lock.lock();
            //队列满了的时候不能读
            while(count==capacity){
                notFull.await();
            }
            enque(e);
        } finally {
            lock.unlock();
        }

    }
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while(count==0){
                notEmpty.await();
            }
            return deque();
        } finally {
            lock.unlock();
        }

    }

    private E deque() {
        @SuppressWarnings("all")
        E e=(E)table[takeIndex];
        table[takeIndex]=null;
        if(++takeIndex==table.length){
            takeIndex=0;
        }
        count--;
        //唤醒写进程
        notFull.signalAll();
        return e;
    }

    private void enque(E e){
        table[putIndex++]=e;
        if(putIndex==table.length){
            putIndex=0;
        }
        count++;
        notEmpty.signalAll();
    }

    //    private Object[] table;
//    private int capacity;
//    private int count = 0;
//    private int putIndex = 0;
//    private int takeIndex = 0;
//
//    private Lock lock;
//    private Condition notFull;//写条件
//    private Condition notEmpty;//读条件
//
//    public XsjArrayBlockingQueue(int tabCount) {
//        if(tabCount<=0){
//            throw new NullPointerException();
//        }
//        table=new Object[tabCount];
//        notFull=lock.newCondition();
//        notEmpty=lock.newCondition();
//    }
//
//
//    public void put(E e) throws InterruptedException {
//        if(e==null){
//            throw new NullPointerException();
//        }
//        try {
//            lock.lock();
//            //队列满了 不能写了
//            while(count==capacity){
//                notEmpty.await();
//            }
//            enque(e);
//        } finally {
//            lock.unlock();
//        }
//    }
//
//
//
//    private void enque(E e){
//        table[putIndex]=e;
//        if(++putIndex==table.length){
//            putIndex=0;
//        }
//        count++;
//        notEmpty.signalAll();
//    }
//
//    public E take() throws InterruptedException {
//        try {
//            lock.lock();
//            while(count==0){
//                notEmpty.await();//读进程阻塞
//            }
//            return dequeue();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    private E dequeue() {
//        @SuppressWarnings("unchecked")
//        E e=(E)table[takeIndex];
//        table[takeIndex]=null;
//        if(++takeIndex==capacity){
//            takeIndex=0;
//        }
//        count--;
//        //唤醒写进程
//        notFull.signalAll();
//
//        return e;
//    }


}
