package chapter6.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xsj
 * @create 2020-10-09 15:04
 */
public class TestUnpark {
    public static void main(String[] args) {
        System.out.println("begin park");
        LockSupport.unpark(Thread.currentThread());
        LockSupport.park();
        System.out.println("end park");
    }
}
