package com.aituigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author xsj
 * @create 2020-09-21 19:26
 */
public class TreeMapTest {
    //想TreeMap中添加key-value,要求必须是同一个类创建的对象
    //因为要按照Key进行排序：自然排序、定制排序
    //自然排序
    @Test
    public void Test1(){
        TreeMap map = new TreeMap();
        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",32);
        User u3 = new User("Jack",20);
        User u4 = new User("Rose",18);
        map.put(u1,23);
        map.put(u2,24);
        map.put(u3,25);
        map.put(u4,26);

        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"---->+"+entry.getValue());
        }
    }
    //定制排序
    //按年龄从小到大
    @Test
    public void Test2(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User) {
                    User user1 = (User) o1;
                    User user2 = (User) o2;
                    return Integer.compare(user1.getAge(), user2.getAge());
                }
                throw new RuntimeException("传入类型错误");
            }
        });
        map.put(new User("Tom",12),123);
        map.put(new User("Jerry",34),456);
        map.put(new User("Tom",29),456);
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Object obj = iterator.next();
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"---->+"+entry.getValue());
        }

    }
}
