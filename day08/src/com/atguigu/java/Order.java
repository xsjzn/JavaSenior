package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsj
 * @create 2020-09-21 20:44
 */
public class Order <T> {
    private String orderName;
    private int orderId;
    private T orderT;

    public Order(){
//编译不通过
//        T[] arr = new T[10];
        //编译通过
        T[] arr = (T[]) new Object[10];
    }
    public Order(String orderName,int orderId,T orderT){
        this.orderName=orderName;
        this.orderId=orderId;
        this.orderT=orderT;
    }
    //如下的三个方法都不是繁星方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }
    //静态方法中不能使用泛型,因为静态方法在类加载时间里，二泛型在对象实例化才出现
    public static void show(){
//        System.out.println(orderT);
    }
    //泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系。
    //换句话说，泛型方法所属的类是不是泛型类都没有关系。
    //泛型方法，可以声明为静态的。原因：泛型参数是在调用方法时确定的。并非在实例化类时确定。
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> res=new ArrayList<>();
        for(E e:arr){
            res.add(e);
        }
        return  res;
    }
}
