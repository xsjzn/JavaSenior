package com.interview.xsj.concurrency.print;

import com.interview.xsj.concurrency.Test;
import sun.print.PrintJob2D;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/** 给一个字符串str 利用 字符串长度的线程数 打印 n次
 * @author xsj
 * @create 2021-12-04 20:50
 */
public class printloopn {
    public static void main(String[] args) {
        print("hello",8);
    }

    private static void print(String str,int n){
        Lock lock=new ReentrantLock();
        char[] cs=str.toCharArray();
        Runnable[] runnables=new Runnable[cs.length];
        Condition[] conditions=new Condition[cs.length];
        for(int i=0;i<cs.length;i++){
            conditions[i]=lock.newCondition();
            runnables[i]=new PrintTask(cs[i],conditions,i,lock);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors()+1, 2, TimeUnit.SECONDS, new LinkedBlockingDeque<>(cs.length));
        //打印
        for(int i=0;i<n;i++){
            for(Runnable runnable:runnables){
                threadPoolExecutor.execute(runnable);
            }
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class PrintTask implements Runnable{
        Character character;
        Condition[] conditions;
        static int idx=0;
        int currentNum;
        Lock lock;

        public PrintTask(Character character,Condition[] conditions,int currentNum,Lock lock){
            this.character=character;
            this.conditions=conditions;
            this.currentNum=currentNum;
            this.lock=lock;
        }
        @Override
        public void run() {
            lock.lock();
            try {
                while(idx!=currentNum){
                    conditions[currentNum].await();
                }
                System.out.print(Thread.currentThread().getName()+":"+character+" ");
                idx=currentNum+1;
                if(idx>=(conditions.length)){
                    idx=0;
                }
                conditions[idx].signal();

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
