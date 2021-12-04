package com.kuang.singleton;

/**
 * @author xsj
 * @create 2020-10-07 19:43
 */
public class HungryMan {
    private HungryMan(){

    }
    private static HungryMan hungryMan=new HungryMan();
    public HungryMan getInstance(){
        return hungryMan;
    }

}
