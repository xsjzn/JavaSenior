package com.interview.xsj.lfu;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xsj
 * @create 2021-05-01 10:45
 */
public class LFUCache {
    class Node{
        int key;
        int value;
        int freq=1;
        Node prev;
        Node next;
        public Node(){}
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    class DoublyLinkedList {
        Node head;
        Node tail;
        public DoublyLinkedList(){
            head=new Node();
            tail=new Node();
            head.next=tail;
            tail.prev=head;
        }
        void removeNode(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;
        }

        void addToHead(Node node){
            node.next=head.next;
            head.next.prev=node;
            head.next=node;
            node.prev=head;
        }
    }
    Map<Integer,Node> cache;//缓存
    Map<Integer,DoublyLinkedList> freqMap;//存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache(int capacity){
        cache=new HashMap<>(capacity);
        freqMap=new HashMap<>();
        this.capacity=capacity;
    }

    public int get(int key){
        Node node = cache.get(key);
        if(node==null){
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key,int value){
        if(capacity==0){
            return;
        }
        Node node=cache.get(key);
        if(node!=null){
            //如果之前key存在
            node.value=value;
            freqInc(node);
        }else{
            //如果之前key不存在
            //如果容量满了
            if(size==capacity){
                DoublyLinkedList minLinkedList = freqMap.get(min);
                //依据key去删除缓存
                cache.remove(minLinkedList.tail.prev.key);
                //从双向链表中删除 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                minLinkedList.removeNode(minLinkedList.tail.prev);
                size--;
            }
            Node newNode=new Node(key,value);
            cache.put(key,newNode);
            DoublyLinkedList linkedList = freqMap.get(1);
            if(linkedList==null){
                linkedList=new DoublyLinkedList();
                freqMap.put(1,linkedList);
            }
            linkedList.addToHead(newNode);
            size++;
            min=1;
        }
    }
    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq=node.freq;
        DoublyLinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        //当前结点的频率对应着最小值 且该频率只有这一个节点
        if(freq==min&&linkedList.head.next==linkedList.tail){
            min=freq+1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if(linkedList==null){
            linkedList = new DoublyLinkedList();
            freqMap.put(freq+1,linkedList);
        }
        linkedList.addToHead(node);
    }





}
