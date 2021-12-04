package com.kuang.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务！
 * * 3000 6000（ForkJoin） 9000（Stream并行流）
 * * // 如何使用 forkjoin
 * * // 1、forkjoinPool 通过它来执行
 * * // 2、计算任务 forkjoinPool.execute(ForkJoinTask task)
 * * // 3. 计算类要继承 ForkJoinTas
 * @author xsj
 * @create 2020-09-30 21:16
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start; // 1
    private Long end; // 1990900000
    // 临界值
    private Long temp = 10000L;
    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if(start-end<temp){
            Long sum=0L;
            for(Long i=start;i<=end;i++){
                sum+=i;
            }
            return sum;
        }else{
            long middle=(start+end)/2;
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            ForkJoinDemo task2 = new ForkJoinDemo(middle+1, end);
            task1.fork();// 拆分任务，把任务压入线程队列
            task2.fork();
            return task1.join()+task2.join();
        }

    }
}
