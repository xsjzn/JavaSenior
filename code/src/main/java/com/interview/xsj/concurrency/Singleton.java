package com.interview.xsj.concurrency;

/**双重校验锁实现对象单例（线程安全）
 * @author xsj
 * @create 2021-03-08 16:52
 */
public class Singleton {
    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
