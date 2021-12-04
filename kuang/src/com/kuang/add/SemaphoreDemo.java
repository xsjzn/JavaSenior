package com.kuang.add;

import java.util.concurrent.Semaphore;

/**
 * @author xsj
 * @create 2020-09-30 16:09
 */
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
