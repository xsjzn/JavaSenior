package chapter1.threadlocal;

/**
 * @author xsj
 * @create 2020-10-05 21:07
 */
public class TestThreadLocal_Inheritable {
    //1.创建线程变量
//    public static ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public static InheritableThreadLocal<String> threadLocal=new InheritableThreadLocal<>();

    public static void main(String[] args) {
        //2 设置线程变量
        threadLocal.set("hello world ");
        new Thread(()->{
            System.out.println("thread:"+threadLocal.get());
        }).start();
        System.out.println("m" +
                "ain:"+threadLocal.get());
    }
}
