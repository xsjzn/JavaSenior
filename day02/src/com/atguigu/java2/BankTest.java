package com.atguigu.java2;

/**使用同步机制将单例模式中的懒汉式变为线程安全的
 * @author xsj
 * @create 2020-09-18 16:35
 */
public class BankTest {

}
class Bank{
    private Bank(){

    }
    private static Bank instance=null;
    //一下两种方式等价，且效率不高，都是单线程
    //使用同步方法
//    public static synchronized Bank getInstance(){
//        if (instance==null){
//            instance=new Bank();
//        }
//        return instance;
//    }
    //使用同步代码块,效率不高，都是单线程
//    public static  Bank getInstance(){
//        synchronized (Bank.class){
//            if (instance==null){
//                instance=new Bank();
//            }
//            return instance;
//        }
//    }
    public static Bank getInstance(){
        if(instance==null){
            synchronized (Bank.class){
                if (instance==null){
                    instance=new Bank();
                }
            }
        }
        return instance;
    }
}
