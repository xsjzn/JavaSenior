package com.atguigu.java;

/**例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 使用同步代码块解决继承Thread类的方式的线程安全问题
 * 說明 ：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器。
 * @author xsj
 * @create 2020-09-18 12:01
 */
class Window2 extends Thread{
    private static int ticket=100;
    private static Object obj =new Object();
    @Override
    public void run() {
        while(true){
//            synchronized(obj){//正確的
//                synchronized (this){ 此時的this表示  window1 window2 window3三個對象
            synchronized (Window2.class){
                if(ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 window1 = new Window2();
        Window2 window2 = new Window2();
        Window2 window3 = new Window2();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }

}
