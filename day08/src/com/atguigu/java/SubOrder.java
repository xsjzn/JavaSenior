package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsj
 * @create 2020-09-21 21:01
 */
public class SubOrder extends Order<Integer> {//不是泛型类，因为已指明
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> res=new ArrayList<>();
        for(E e:arr){
            res.add(e);
        }
        return  res;
    }
}
