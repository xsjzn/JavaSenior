package com.atguigu.exer4;

/**模拟银行取钱的问题
 1.定义一个Account类
 1）该Account类封装了账户编号（String）和余额（double）两个属性
 2）设置相应属性的getter和setter方法
 3）提供无参和有两个参数的构造器
 4）系统根据账号判断与用户是否匹配，需提供hashCode()和equals()方法的重写
 2.提供两个取钱的线程类：小明、小明’s wife
 1）提供了Account类的account属性和double类的取款额的属性
 2）提供带线程名的构造器
 3）run()方法中提供取钱的操作
 3.在主类中创建线程进行测试。考虑线程安全问题。
 * @author xsj
 * @create 2020-09-18 21:50
 */
public class WithDrawThreadTest {
    public static void main(String[] args) {
        Account acct = new Account("123", 10000);
//        WithDrawThread t1 = new WithDrawThread("小明", acct, 8000);
//        WithDrawThread t2 = new WithDrawThread("小明's wife", acct, 8000);
        //或者可以用多态
        Thread t1 = new WithDrawThread("小明", acct, 8000);
        Thread t2 = new WithDrawThread("小明's wife", acct, 8000);
        t1.start();
        t2.start();
    }
}
