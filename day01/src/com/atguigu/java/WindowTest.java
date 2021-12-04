package com.atguigu.java;

/**例子：创建三个窗口卖票，总票数为100张.使用继承Thread类的方式
 *
 * 存在线程的安全问题，待解决。
 * @author xsj
 * @create 2020-09-18 12:01
 */
class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(getName() + "：卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window window1 = new Window();
        Window window2 = new Window();
        Window window3 = new Window();

        window1.setName("窗口1");
        window2.setName("窗口2");
        window3.setName("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }

}
