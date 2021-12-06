package com.interview.xsj.lru;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyLRUCacheWithExpireTime<K,V> {

    private static volatile MyLRUCacheWithExpireTime instance=null;

    /**
     *  缓存最大容量
     */
    private final int maxCapacity;
    private ConcurrentLinkedQueue<K> keys;
    private ConcurrentHashMap<K,V> cacheMaps;

    /**
     * 读写锁
     */
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Lock writeLock = readWriteLock.writeLock();
    private Lock readLock = readWriteLock.readLock();
    private ScheduledExecutorService scheduledExecutorService;

    private MyLRUCacheWithExpireTime(int maxCapacity){
        if (maxCapacity < 0) {
            throw new IllegalArgumentException("Illegal max capacity: " + maxCapacity);
        }
        this.maxCapacity=maxCapacity;
        keys=new ConcurrentLinkedQueue<>();
        cacheMaps=new ConcurrentHashMap<>();
        scheduledExecutorService= Executors.newScheduledThreadPool(3);
    }

    /**
     * dcl  单例模式
     * @param capacity
     * @return
     */
    public static MyLRUCacheWithExpireTime getInstance(int capacity){
        if(instance==null){
            synchronized (MyLRUCacheWithExpireTime.class){
                if(instance==null){
                    instance=new MyLRUCacheWithExpireTime(capacity);
                }
            }
        }
        return instance;
    }

    public V get(K key){
        readLock.lock();
        try{
            if(cacheMaps.containsKey(key)){
                //存在的话 把该节点 移动到队头
                moveToHead(key);
                return cacheMaps.get(key);
            }
            return null;
        }finally {
            readLock.unlock();
        }
    }

    /**
     * 把该节点 移动到队头
     * @param key
     */
    private void moveToHead(K key){
        keys.remove(key);
        keys.add(key);
    }

    public V put(K key,V value,long expireTime){
        writeLock.lock();
        try{
            //1.存在就移动到队头 并且覆盖
            if(cacheMaps.containsKey(key)){
                moveToHead(key);
                cacheMaps.put(key,value);
                return value;
            }

            //2.如果数量已经超了的话就 删除 最老的元素
            if(keys.size()==maxCapacity){
                System.out.println("maxCapacity of cache reached");
                removeOldestKey();
            }
            //3.插入新节点
            cacheMaps.put(key,value);
            keys.add(key);
            if(expireTime>0){
                removeAfterExpireTime(key,expireTime);
            }
            return value;
        }finally {
            writeLock.unlock();
        }
    }

    private void removeAfterExpireTime(K key, long expireTime) {
        scheduledExecutorService.schedule(()->{
            remove(key);
        },expireTime, TimeUnit.MILLISECONDS);
    }

    private void remove(K key) {
        if(cacheMaps.containsKey(key)){
            keys.remove(key);
            cacheMaps.remove(key);
        }
    }

    private void removeOldestKey() {
        K tail = keys.poll();
        if(tail!=null){
            cacheMaps.remove(tail);
        }
    }
    public int size(){
        return cacheMaps.size();
    }
}
