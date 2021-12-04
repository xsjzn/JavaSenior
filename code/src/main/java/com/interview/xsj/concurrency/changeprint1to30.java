package com.interview.xsj.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程，分别打印1-10，11-20，21-30，
 * 要求同时进行，同时最后需要这些数的和全部加起来打印。
 * 即在主线程中进行打印(1-30的和)
 * @author xsj
 * @create 2021-04-02 10:46
 */
public class changeprint1to30 {
    private static int printNum=1;
    private static int sum=0;
    private static volatile int cnt=0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Lock lock=new ReentrantLock();
        Condition condition1=lock.newCondition();
        Condition condition2=lock.newCondition();



        new Thread(()->{
            lock.lock();
            try {
                for(int i=0;i<10;i++){
                    sum+=printNum;
                    System.out.println(Thread.currentThread().getName()+"---"+printNum++);
                }
                cnt++;

                countDownLatch.countDown();
                condition1.signal();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }


        }).start();

        new Thread(()->{
            lock.lock();
            try{
                while(cnt!=1){
                    condition1.await();
                }
                for(int i=0;i<10;i++){
                    sum+=printNum;
                    System.out.println(Thread.currentThread().getName()+"---"+printNum++);
                }
                cnt++;
                condition2.signal();
                countDownLatch.countDown();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }

        }).start();

        new Thread(()->{
            lock.lock();
            try{
                while(cnt!=2){
                    condition1.await();
                }
                for(int i=0;i<10;i++){
                    sum+=printNum;
                    System.out.println(Thread.currentThread().getName()+"---"+printNum++);
                }
                cnt++;
                countDownLatch.countDown();
            }catch (Exception e){

            }finally {
                lock.unlock();
            }
        }).start();



        countDownLatch.await();
        System.out.println("总数为"+sum);

    }
}
