package com.atguigu.java;

/**多线程的创建 方式一，继承与Thread类：
 * 1.创建一个继承与Thread类的子类
 * 2.重写Thread类的run();
 * 3.创建该子类的对象
 * 4.通过此对象调用start方法
 * <p> 遍历100以内的所有偶数u
 * @author xsj
 * @create 2020-09-18 10:45
 */
//1、创建一个继承与Thread类的子类
class MyThread extends Thread{
    public MyThread(){
        super();
    }
    //2.重写Thread类的run();
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println("子线程"+Thread.currentThread().getName()+": "+i);
            }
        }

    }
}
public class ThreadTest {
    public static void main(String[] args) {
        //3.创建该子类的对象
        MyThread mt1=new MyThread();
        MyThread mt2=new MyThread();
        //4.通过此对象调用start方法 作用1.启动当前线程 2.调用当前线程的run方法

        mt1.start();
        mt2.start();
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println("主线程"+Thread.currentThread().getName()+i+"******");
            }
        }
    }

}
