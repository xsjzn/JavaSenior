package com.kuang.threadPool;

import java.util.concurrent.*;

/**Executors工具类
 *
 * new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，不处理这个人的，抛出异常
 *  * new ThreadPoolExecutor.CallerRunsPolicy() // 哪来的去哪里！
 *  * new ThreadPoolExecutor.DiscardPolicy() //队列满了，丢掉任务，不会抛出异常！
 *  * new ThreadPoolExecutor.DiscardOldestPolicy() //队列满了，尝试去和最早的竞争，也不会抛出异常！
 * @author xsj
 * @create 2020-09-30 20:11
 */
public class ThreadPool {
    public static void main(String[] args) {
        // 最大线程到底该如何定义
        //1.CPU密集型 几核，就是几，可以保持CPu的效率最高！
        //2.IO  密集型   > 判断你程序中十分耗IO的线程，
        // 程序   15个大型任务  io十分占用资源！

        //不建议用这种方法 因为不安全
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool2 = Executors.newCachedThreadPool();
        // 获取CPU的核数
        System.out.println(Runtime.getRuntime().availableProcessors());
        //最大容量 maximumPoolSize+LinkedBlockingDeque<>(3)
        // 最大承载：Deque + max
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 3, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3)
                , Executors.defaultThreadFactory()
                , new ThreadPoolExecutor.DiscardOldestPolicy());
        //超过的话RejectedExecutionException
        for (int i = 1; i <=10 ; i++) {
            threadPoolExecutor.execute(()-> System.out.println(Thread.currentThread().getName()+"ok"));
        }
    }
}
