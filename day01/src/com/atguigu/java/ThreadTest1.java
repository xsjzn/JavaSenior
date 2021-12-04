package com.atguigu.java;

/** The other way to create a thread is to declare a class that implements the Runnable interface.
 *  That class then implements the run method. An instance of the class can then be allocated,
 *  passed as an argument when creating Thread, and started.
 *  创建多线程方式二：实现runnable接口
 *  1、创建一个实现runnable接口的类
 *  2. 实现类去实现Runnable中的抽象方法：run()
 *  3. 创建实现类的对象
 *  4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 *  5. 通过Thread类的对象调用start()
 *
 *  比较两种创建多线程的方式
 *  开发中：优先选择：实现runnable接口中的方式
 *  原因：1实现的方式没有类的单继承的局限性
 *      2.实现的方式更适合用来处理多个线程共享数据的情况，
 *      例如 卖票例子中 ticket 实现方式中不需要给 ticket 加static
 *  联系：public class Thread implements Runnable
 *  相同点 两种方法都需要重写run(),将线程要执行的逻辑声明在run()中
 * @author xsj
 * @create 2020-09-18 14:10
 */
//1、创建一个实现runnable接口的类
class MyThread1 implements Runnable{
    //2 实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {
        //3. 创建实现类的对象
        MyThread1 myThread1 = new MyThread1();
        //4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(myThread1);
        //5. 通过Thread类的对象调用start() ① 启动线程 ②调用当前线程的run()-->调用了Runnable类型的target的run()
        t1.start();
        //方法二
//        new Thread(myThread1).start();
    }

}
