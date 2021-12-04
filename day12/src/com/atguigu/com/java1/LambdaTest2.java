package com.atguigu.com.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author xsj
 * @create 2020-09-25 14:26
 */
public class LambdaTest2 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("花费了"+aDouble+"元");
            }
        });
        System.out.println("********************");
        happyTime(1000,money-> System.out.println("娱乐了"+money+"元"));
    }
    public void happyTime(double money, Consumer<Double> con){
            con.accept(money);
    }
    @Test
    public void test2(){
        List<String> list= Arrays.asList("北京","南京","天津","东京","西京","普京");
        List<String> listFil = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(listFil);

        List<String> listFil1 = filterString(list, (s) -> s.contains("津"));
        System.out.println(listFil1);

    }
    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre){
        List<String> res=new ArrayList<>();
        for(String s:list){
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }
}
