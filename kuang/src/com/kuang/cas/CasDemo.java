package com.kuang.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xsj
 * @create 2020-10-07 21:17
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        System.out.println(atomicInteger.compareAndSet(2020,2021));//true
        System.out.println(atomicInteger.get());//2021
        // ============== 捣乱的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());
        // ============== 期望的线程 ==================
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());
    }
}
