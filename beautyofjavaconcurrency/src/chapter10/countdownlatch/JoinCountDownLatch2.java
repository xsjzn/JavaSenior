package chapter10.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2020-10-16 15:13
 */
public class JoinCountDownLatch2 {
    private static CountDownLatch countDownLatch=new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("child threadOne over!");
                countDownLatch.countDown();
            }
        });
        threadPoolExecutor.submit(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("child threadTwo over!");
                countDownLatch.countDown();
            }
        });
        System.out.println("wait all child thread  over");
        countDownLatch.await();
//        Thread.sleep(1000);
        System.out.println("all child thread over");
        threadPoolExecutor.shutdown();
    }
}
