package com.interview.xsj.singleton.dcl;

/**
 * @author xsj
 * @create 2021-03-25 19:23
 */
public class Singleton {

    private volatile static Singleton instance;

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
