package com.kuang.add;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author xsj
 * @create 2020-09-30 15:56
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,
                () ->System.out.println("终于集齐7个龙珠，召唤神龙"));
        for (int i = 1; i <= 7; i++) {
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集了第"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
