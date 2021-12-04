package chapter10.cyclebarrier;

import java.util.concurrent.*;

/**
 * @author xsj
 * @create 2020-10-18 17:24
 */
public class CycleBarrierTest2 {
    private static CyclicBarrier cyclicBarrier=new CyclicBarrier(2);

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.submit(()->{
            try {
                System.out.println(Thread.currentThread()+"step 1");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step 2");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.submit(()->{
            try {
                System.out.println(Thread.currentThread()+"step 1");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step 2");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread()+"step 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        threadPoolExecutor.shutdown();
    }
}
