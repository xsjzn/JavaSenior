package com.interview.xsj.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用多线程交替打印字符hello hello hello …
 * @author xsj
 * @create 2021-03-09 19:22
 */
public class Test {
    public static void main(String[] args) {
        printl("hello");
    }

    public static void printl(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        char[] chars = (str + " ").toCharArray();

        Executor executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() + 1, 2, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(chars.length));

        List<Runnable> runnableList = new ArrayList<Runnable>(chars.length);
        Lock lock = new ReentrantLock();
        Condition[] conditions = new Condition[chars.length];
        for (int i = 0; i < chars.length; i++) {
            conditions[i] = lock.newCondition();
            runnableList.add(new PrintTask(chars[i], i, lock, conditions));

        }
        while (true) {
            for (Runnable runnable : runnableList) {
                executor.execute(runnable);
            }
            try {
                // 睡眠防止队列太快满 拒绝处理
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }

    }

    static class PrintTask implements Runnable {

        private Character character;
        private int currentId;
        private static int num = 0;
        private Lock lock;
        private Condition[] conditionList;

        public PrintTask(Character character, int currentId, Lock lock, Condition[] conditionList) {
            this.currentId = currentId;
            this.lock = lock;
            this.character = character;
            this.conditionList = conditionList;

        }

        @Override
        public void run() {
            lock.lock();
            try {
                //判断一下是不是到我了
                while (num != currentId) {
                    conditionList[currentId].await();
                }
                System.out.printf(String.valueOf(character));
                num = currentId + 1;
                if (num >= (conditionList.length)) {
                    num = 0;
                }
                conditionList[num].signal();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

