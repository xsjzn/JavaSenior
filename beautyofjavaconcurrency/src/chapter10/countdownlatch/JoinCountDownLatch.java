package chapter10.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author xsj
 * @create 2020-10-16 15:08
 */
public class JoinCountDownLatch {
    private static volatile CountDownLatch countDownLatch=new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        },"Thread1").start();
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        },"Thread2").start();
        System.out.println("wait all child thread over over");
        countDownLatch.await();
        System.out.println("all child thread over");
    }
}
