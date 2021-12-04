package chapter10.cyclebarrier;

import java.util.concurrent.*;

/**
 * @author xsj
 * @create 2020-10-18 14:50
 */
public class CycleBarrierTest1 {
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(2,()->{
        System.out.println(Thread.currentThread()+" task1 merge result");
    });

    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPool.submit(()->{
            try {
                System.out.println(Thread.currentThread()+ " task1-1");
                System.out.println(Thread.currentThread()+ " enter in barrier");

                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+ " enter out barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPool.submit(()->{
            try {
                System.out.println(Thread.currentThread()+ " task1-2");
                System.out.println(Thread.currentThread()+ " enter in barrier");

                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+ " enter out barrier");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPool.shutdown();
    }
}
