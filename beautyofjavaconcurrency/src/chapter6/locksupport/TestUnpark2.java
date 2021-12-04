package chapter6.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xsj
 * @create 2020-10-09 15:06
 */
public class TestUnpark2 {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            System.out.println("child thread begin park");
            LockSupport.park();
            System.out.println("child thread unpark");
        });
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread begin uopark");
        LockSupport.unpark(thread);
    }
}
