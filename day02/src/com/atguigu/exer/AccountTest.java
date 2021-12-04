package com.atguigu.exer;

/**银行 有一 个账户。
 有两个储户存 分别向同一个账户存3000 元，存 每次存1000， 存3次 。每次存完打印账户余额。
 问题：该程序是否有安全问题，如果有，如何解决？
 【提示】
 1，明确哪些代码是多线程运行代码，须写入run()方法
 2，明确什么是共享数据。 balance
 3，明确多线程运行代码中哪些语句是操作共享数据的
 * @author xsj
 * @create 2020-09-18 17:50
 */
class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }
    public synchronized void deposit(int amt){
        if(amt>0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance+=amt;
            System.out.println(Thread.currentThread().getName()+"存款成功:当前余额为"+balance);
        }
    }
}
class Customer extends Thread{
    private Account account;
//    private String name;
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }
    }

    public Customer(Account account) {
        this.account = account;
    }
}
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(0);
        Customer customer1 = new Customer(acct);
        Customer customer2 = new Customer(acct);
        customer1.setName("小明");
        customer2.setName("小红");
        customer1.start();
        customer2.start();
    }
}
