package com.interview.xsj.lru.withoutJdk;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xsj
 * @create 2021-04-30 15:10
 */
public class LRUCache {
    class DlinkedNode{
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
        public DlinkedNode(){}
        public DlinkedNode(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    private Map<Integer,DlinkedNode> cache=new HashMap<>();
    private int size;
    private int capacity;
    private DlinkedNode head,tail;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity = capacity;//总容量
        //使用伪头部和伪尾部节点
        head=new DlinkedNode();
        tail=new DlinkedNode();
        head.next=tail;
        tail.prev=head;
    }


    public int get(int key){
        lock.readLock().lock();
        try {
            DlinkedNode node = cache.get(key);
            if(node==null) return -1;
            //如果key存在 先通过哈希表定位，再移到头部
            moveToHead(node);
            return node.value;
        } finally {
            lock.readLock().unlock();
        }
    }

    private void moveToHead(DlinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 相当于双向链表的头插法
     * @param node
     */
    private void addToHead(DlinkedNode node) {
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
        node.prev=head;
    }

    private void removeNode(DlinkedNode node) {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void put(int key,int value){
        lock.writeLock().lock();
        try {
            DlinkedNode node = cache.get(key);
            if(node==null){
                //如果key不存在则创建一个新的结点
                DlinkedNode newNode = new DlinkedNode(key, value);
                //添加进哈希表
                cache.put(key,newNode);
                //添加至双向链表头部
                addToHead(newNode);
                ++size;
                //如果超过了容量 那么要移除队尾的元素
                if(size>capacity){
                    DlinkedNode tail = removeTail();
                    // 删除哈希表中对应的项
                    cache.remove(tail.key);
                    --size;
                }

            }else{
                //如果key 存在，先通过哈希表定位，再修改val 并移动到头部
                node.value=value;
                moveToHead(node);
            }
        } finally {
            lock.writeLock().lock();
        }
    }

    private DlinkedNode removeTail() {
        DlinkedNode res=tail.prev;
        removeNode(res);
        return res;
    }


}
