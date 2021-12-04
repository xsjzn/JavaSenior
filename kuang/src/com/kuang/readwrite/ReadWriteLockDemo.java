package com.kuang.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xsj
 * @create 2020-09-30 19:15
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCacheLock=new MyCacheLock();
        for (int i = 1; i <= 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCacheLock.put(temp+" ",temp+"");
            }).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int temp=i;
            new Thread(()->{
                myCacheLock.get(temp+" ");
            }).start();
        }
    }

}
// 加锁的
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
    // 存，写入的时候，只希望同时只有一个线程写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入OK");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }
    //允许多个线程读
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取OK");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
}
