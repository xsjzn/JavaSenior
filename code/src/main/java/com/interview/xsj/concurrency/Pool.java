package com.interview.xsj.concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2021-03-12 21:49
 */
public class Pool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors() + 1, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        try {
            for(int i=0;i<100;i++){
                executor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
