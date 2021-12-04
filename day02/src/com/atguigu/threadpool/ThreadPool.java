package com.atguigu.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xsj
 * @create 2020-09-19 11:32
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        //设置线程池属性
        service1.setCorePoolSize(15);
        //2.执行指定的线程操作。需提供Runnabale或Callble接口实现类的对象
        service.execute(new NumberThread());
        service.execute(new NumberThread1());//适合runnable接口
        //        service.submit(Callable callable);//适合使用于Callable
        //3.关闭连接池
        service.shutdown();
    }
}
