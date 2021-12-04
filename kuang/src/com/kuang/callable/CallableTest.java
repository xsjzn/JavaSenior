package com.kuang.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xsj
 * @create 2020-09-30 19:24
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"b").start();//有缓存
        Integer integer = futureTask.get();
        System.out.println(integer);
    }
}
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("call");
        return 123;
    }
}
