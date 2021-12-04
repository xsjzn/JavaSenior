package com.atguigu.java;

/**例子：创建三个窗口卖票，总票数为100张.使用实现runnable的方式
 * @author xsj
 * @create 2020-09-18 14:35
 */
//1、创建一个实现runnable接口的类
// *  2. 实现类去实现Runnable中的抽象方法：run()
class window2 implements Runnable{
    private  int ticket=100;

    @Override
    public void run() {
        while(true){
            if(ticket>0){
                System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
public class WindowTest1 {

    public static void main(String[] args) {
        //3创建实现类的对象
        window2 myWindow = new window2();
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
