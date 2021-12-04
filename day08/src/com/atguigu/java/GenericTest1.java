package com.atguigu.java;

import org.junit.Test;

import java.util.List;

/**
 * @author xsj
 * @create 2020-09-21 20:47
 */
public class GenericTest1 {


    @Test
    public void Test1(){
        //如果定义了泛型类，实例化没有指明类的泛型，则认为此泛型类型为Object类型
        //要求：如果大家定义了类是带泛型的，建议在实例化时要指明类的泛型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("avc");


        //建议：实例化指明类型
        Order<String> stringOrder = new Order<>("小明", 123, "学校");
    }
    @Test
    public void Test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承带泛型的父类时，指明了泛型类型。则实例化子类对象时，不再需要指明泛型。
        subOrder.setOrderT(123);
    }
    @Test
    public void Test3(){
        Order<String> order = new Order<>();
        Integer[] arr =new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数类型。该类型和类的类型无关
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);//[1, 2, 3, 4]

    }

}
