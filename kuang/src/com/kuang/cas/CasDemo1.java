package com.kuang.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xsj
 * @create 2020-10-07 21:42
 */
public class CasDemo1 {
    //AtomicStampedReference 注意，如果泛型是一个包装类，注意对象的引用问题
    // 正常在业务操作，这里面比较的都是一个个对象
    static AtomicStampedReference<Integer> atomicStampedReference=new AtomicStampedReference<>(1,1);
    // CAS  compareAndSet : 比较并交换！
    public static void main(String[] args) {
        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("a1=>"+stamp);
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("a2=>"+atomicStampedReference.getStamp());

            System.out.println(atomicStampedReference.compareAndSet(2, 1,
                    atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));

            System.out.println("a3=>"+atomicStampedReference.getStamp());
        },"a").start();
        new Thread(()->{
            int stamp=atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 6, stamp, stamp + 1));
            System.out.println("b2=>"+atomicStampedReference.getStamp());

        }).start();
        
    }
}
