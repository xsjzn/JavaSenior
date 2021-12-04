package com.kuang.add;

import java.util.concurrent.CountDownLatch;

/**
 * @author xsj
 * @create 2020-09-30 15:48
 */
public class CountDownDemo {
    public static void main(String[] args) {
        try {
            CountDownLatch count = new CountDownLatch(6);
            for (int i = 0; i < 6; i++) {
                new Thread(()->{
                    System.out.println(Thread.currentThread().getName()+"Go Out");
                    count.countDown();
                },String.valueOf(i)).start();
            }
            count.await();
            System.out.println("Close Door");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
