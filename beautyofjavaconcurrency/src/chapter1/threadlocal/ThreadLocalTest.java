package chapter1.threadlocal;

import org.junit.Test;

/**
 * @author xsj
 * @create 2020-10-05 20:56
 */
public class ThreadLocalTest {
    //创建Threadlocal变量
    static ThreadLocal<String> localVariable=new ThreadLocal<>();

    static void print(String str){
        //1.1打印当前localVariable变量的值
        System.out.println(str+":"+localVariable.get());
        //1.2清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadOne = new Thread(()->{
            //3.1设置One线程中本地变量localVariable的值
            localVariable.set("threadOne local Variable");
            //3.2调用打印函数
            print("Thread One");
            //3.3打印本地变量值
            System.out.println("threadOne remove after "+localVariable.get());
        });
        Thread threadTwo = new Thread(()->{
            //3.1设置One线程中本地变量localVariable的值
            localVariable.set("threadTwo local Variable");
            //3.2调用打印函数
            print("Thread Two");
            //3.3打印本地变量值
            System.out.println("threadTwo remove after "+localVariable.get());
        });
        threadOne.start();
        threadTwo.start();
    }
    @Test
    public void Test(){
        ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                integerThreadLocal.set(i);
                System.out.println("存入"+i);
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
                integerThreadLocal.get();
                System.out.println("得到"+i);
            }
        }).start();
    }
}
