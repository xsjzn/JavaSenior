package chapter10.semaphore;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2020-10-18 18:09
 */
public class SemaphoreTest1 {
    //创建一个semaphore实例
    private static Semaphore semaphore=new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" over");
            semaphore.release();
        });
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" over");
            semaphore.release();
        });
        semaphore.acquire(2);
        System.out.println("All child thread over");
        //关闭线程池
        threadPoolExecutor.shutdown();
    }
}
