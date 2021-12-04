package com.atguigu.com.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author xsj
 * @create 2020-09-25 12:07
 */
public class LambdaTest1 {
    //语法格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };

        r1.run();

        System.out.println("***********************");
        Runnable r2=()-> System.out.println("wozuiniu");
        r2.run();
    }
    //语法格式二：Lambda 需要一个参数，但是没有返回值。
    @Test
    public void test2(){

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("谎言和誓言的区别是什么？");

        System.out.println("*******************");
        Consumer<String> con2=s-> System.out.println(s);
        con2.accept("123");
    }

    //语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test6(){

        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        System.out.println(com1.compare(12,21));

        System.out.println("*******************");

        Comparator<Integer>com2 =(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        System.out.println(com2.compare(12,4));


    }
}
