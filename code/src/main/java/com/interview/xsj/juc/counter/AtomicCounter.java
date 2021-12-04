package com.interview.xsj.juc.counter;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xsj
 * @create 2021-05-05 19:34
 */
public class AtomicCounter {
    static AtomicInteger counter=new AtomicInteger();

    public static void add(int i){
//        counter.getAndAdd(i);直接这样加也可以
        while(true){
            int oldValue=counter.get();
            int newValue=oldValue+i;
            if(counter.compareAndSet(oldValue,newValue)){
                return;
            }
        }
    }
    public static int getCount(){
        return counter.get();
    }
}
