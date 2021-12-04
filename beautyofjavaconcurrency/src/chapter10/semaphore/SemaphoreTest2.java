package chapter10.semaphore;

import java.util.concurrent.*;

/**
 *
 * 体现semaphore复用性
 * @author xsj
 * @create 2020-10-18 19:07
 */
public class SemaphoreTest2 {
    private static volatile Semaphore semaphore=new Semaphore(2);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" A TASK Over");
            semaphore.release();
        });
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" A TASK Over");
            semaphore.release();
        });
        semaphore.acquire(2);
        System.out.println("Task A is over" );
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" B TASK Over");
            semaphore.release();
        });
        threadPoolExecutor.submit(()->{
            System.out.println(Thread.currentThread()+" B TASK Over");
            semaphore.release();
        });
        semaphore.acquire(2);
        System.out.println("Task B is over" );
        threadPoolExecutor.shutdown();
    }
}
