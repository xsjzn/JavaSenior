package com.atguigu.java;

/**例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 使用同步方法解决继承Thread类的方式的线程安全问题
 * 說明 ：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 * @author xsj
 * @create 2020-09-18 12:01
 */
class Window4 extends Thread{
    private static int ticket=100;
    private static Object obj =new Object();
    @Override
    public void run() {
        while(true){
            show();
        }
    }

    private static synchronized void show() {//同步监视器 Window4.class
        //如果是private synchronized void show() {同步监视器this 错误
        if(ticket>0){
            try {
                Thread.sleep(100);
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
public class WindowTest4 {
    public static void main(String[] args) {
        Window4 window1 = new Window4();
        Window4 window2 = new Window4();
        Window4 window3 = new Window4();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }

}
