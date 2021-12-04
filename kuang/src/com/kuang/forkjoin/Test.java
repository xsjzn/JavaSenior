package com.kuang.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @author xsj
 * @create 2020-09-30 21:41
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test3();
    }
    public static void test1(){
        Long sum = 0L;
        long start = System.currentTimeMillis();
        for (Long i = 1L; i <= 10_0000_000; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
    // 会使用ForkJoin
    public static void test2() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinDemo task = new ForkJoinDemo(0L, 10_0000_000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum=submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
    // Stream并行流 ()
    public static void test3() throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        long sum = LongStream.rangeClosed(0L, 10_0000_000L).parallel().reduce(0, Long::sum);


        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }
}
