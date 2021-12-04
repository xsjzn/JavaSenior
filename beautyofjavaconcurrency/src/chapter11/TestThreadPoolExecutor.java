package chapter11;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2020-10-24 19:48
 */
public class TestThreadPoolExecutor {
    static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) {
        scheduledThreadPoolExecutor.schedule(()->{
            System.out.println("---one task");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("error ");
        },500, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.schedule(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("---Two Task---");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000, TimeUnit.MILLISECONDS);
        scheduledThreadPoolExecutor.shutdown();
    }
}
