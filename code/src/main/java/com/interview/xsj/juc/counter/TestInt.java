package com.interview.xsj.juc.counter;

/**设计一个线程安全的计数器
 * @author xsj
 * @create 2021-05-05 19:33
 */
public class TestInt {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<100;i++){
            new Thread(()->{
                for(int j=0;j<10;j++){
                    AtomicCounter.add(1);
                }
            }).start();
        }
        Thread.sleep(1000);
        System.out.println(AtomicCounter.getCount());
    }

}
