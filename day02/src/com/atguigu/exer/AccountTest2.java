package com.atguigu.exer;

import java.util.concurrent.locks.ReentrantLock;

/**有一 个账户。
 有两个储户存 分别向同一个账户存3000 元，存 每次存1000， ， 存3次 。每次存完打印账户余额。
 问题：该程序是否有安全问题，如果有，如何解决？
 【提示】
 1，明确哪些代码是多线程运行代码，须写入run()方法
 2，明确什么是共享数据。 balance
 3，明确多线程运行代码中哪些语句是操作共享数据的
 * @author xsj
 * @create 2020-09-18 20:56
 */
class Account2{
    private static int balance;
    private ReentrantLock lock=new ReentrantLock();
    public void deposit(int money){
        if(money>0){
            try{
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance+=money;
                System.out.println(Thread.currentThread().getName()+"存钱成功"+balance);
            }finally {
                lock.unlock();
            }
        }
    }

    public Account2(int balance) {
        this.balance = balance;
    }
}
class Cutomer2 implements Runnable{
    private Account2 acct2;
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            acct2.deposit(1000);
        }
    }

    public Cutomer2(Account2 acct2) {
        this.acct2 = acct2;
    }
}
public class AccountTest2 {
    public static void main(String[] args) {
        Account2 acct2=new Account2(0);
        Cutomer2 cutomer2 = new Cutomer2(acct2);
        Thread t1 = new Thread(cutomer2);
        Thread t2 = new Thread(cutomer2);

        t1.setName("顾客1");
        t2.setName("顾客2");

        t1.start();
        t2.start();
    }

}
