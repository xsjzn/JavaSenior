package com.interview.xsj.singleton.staticInner;

/**
 * @author xsj
 * @create 2021-05-11 10:10
 */
public class Singleton {
    private Singleton(){

    }

    /**
     * 此处使用一个静态内部类来维护单例
     */
    private static class SingletonFactory{
        private static Singleton instance=new Singleton();
    }

    /* 获取实例 */
    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    /* 如果该对象被用于序列化，可以保证对象在序列化前后保持一致 */
    public Object readResolve() {
        return getInstance();
    }

}
