package com.atguigu.exer;

/**闯将两个线程，一个打印100以内奇数，一个打印100以内偶数
 * @author xsj
 * @create 2020-09-18 11:17
 */
public class ThreadTest {
    public static void main(String[] args) {
//        MyThread1 mt1=new MyThread1();
//        MyThread2 mt2=new MyThread2();
//        mt1.start();
//        mt2.start();
        //1创建Thread类的匿名子类
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+": "+i);
                    }
                }
            }
        }.start();
    }
}
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}