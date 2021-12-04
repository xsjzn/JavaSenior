package chapter6.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author xsj
 * @create 2020-10-09 14:58
 */
public class TestPark {
    public static void main(String[] args) {
        System.out.println("begin park");
        LockSupport.park();
        System.out.println("end park");
    }
}
