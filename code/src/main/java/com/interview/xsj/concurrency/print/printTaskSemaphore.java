package com.interview.xsj.concurrency.print;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xsj
 * @create 2021-12-04 21:34
 */
public class printTaskSemaphore {
    public static void main(String[] args) {
        print("hello",8);
    }

    private static void print(String str, int count) {
        char[] cs=str.toCharArray();
        Semaphore[] semaphores=new Semaphore[cs.length];
        Runnable[] runnables=new Runnable[cs.length];
        for(int i=0;i<cs.length;i++){
            semaphores[i]=i==0?new Semaphore(1):new Semaphore(0);
            runnables[i]=new PrintTaskUseSem(cs[i],semaphores,i);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(), Runtime.getRuntime().availableProcessors(), 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        for(int i=0;i<count;i++){
            for(Runnable runnable:runnables){
                threadPoolExecutor.execute(runnable);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }


    }

    static class PrintTaskUseSem implements Runnable{
        Character character;
        Semaphore[] semaphores;
        static int num=0;
        int currentNum;
        public PrintTaskUseSem(Character character,Semaphore[] semaphores,int currentNum){
            this.character=character;
            this.semaphores=semaphores;
            this.currentNum=currentNum;
        }


        @Override
        public void run() {

            try {
                semaphores[currentNum].acquire();
                System.out.print(Thread.currentThread().getName()+": "+character+" ");
                num=currentNum+1;
                if(num>=semaphores.length){
                    num=0;
                }
                semaphores[num].release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
