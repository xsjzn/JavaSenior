package com.kuang.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author xsj
 * @create 2020-10-07 19:45
 */
public class LazyMan {
    private static boolean qinjiang=false;
    private LazyMan(){
        synchronized (LazyMan.class){
            if(qinjiang==false){
                qinjiang=true;
            }else{
                throw new RuntimeException("不要试图使用反射破坏单例异常");
            }
//            if(lazyMan!=null){
//                throw new RuntimeException("不要试图使用反射破坏异常");
//            }
        }

    }
    private volatile static LazyMan lazyMan;
    //双重检测模式的 懒汉式单利，DCL单例
    public static LazyMan getInstance(){
        if(lazyMan==null){
            synchronized (LazyMan.class){
                if(lazyMan==null){
                    lazyMan=new LazyMan();// 不是一个原子性操作
                }
            }
        }
        return lazyMan;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

//        for (int i = 0; i < 20; i++) {
//            new Thread(()->{
//                LazyMan instance = LazyMan.getInstance();
//            }).start();
//        }
        //反射
        LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);//无视私有构造器
        LazyMan instance2 = declaredConstructor.newInstance(null);
        System.out.println(instance);
        System.out.println(instance2);
    }
}
/**
 * 1. 分配内存空间
 * 2、执行构造方法，初始化对象
 * 3、把这个对象指向这个空间
 *
 * 123
 * 132 A
 *     B // 此时lazyMan还没有完成构造
 */
