package com.kuang.singleton;

/**
 * @author xsj
 * @create 2020-10-07 20:01
 */
//静态内部类
public class Holder {
    private Holder(){

    }
    public static Holder getInstance(){
        return Inner.HOLDER;
    }

    public static class Inner{
        private final static Holder HOLDER=new Holder();
    }
}
