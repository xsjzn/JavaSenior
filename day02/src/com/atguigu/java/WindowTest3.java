package com.atguigu.java;

import static java.lang.Thread.sleep;

/**
 * @author xsj
 * @create 2020-09-18 16:13
 * *  关于同步方法的总结：
 *  1. 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明。
 *  2. 非静态的同步方法，同步监视器是：this
 *     静态的同步方法，同步监视器是：当前类本身
 */
class window3 implements Runnable{
    private int ticket=100;
    Object obj=new Object();
    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private synchronized void show() {//同步监视器：this
        if(ticket>0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
            ticket--;
        }else{
            return;
        }
    }

}

public class WindowTest3 {

    public static void main(String[] args) {
        //3创建实现类的对象
        window3 myWindow = new window3();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread window1 = new Thread(myWindow);
        Thread window2 = new Thread(myWindow);
        Thread window3 = new Thread(myWindow);

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
