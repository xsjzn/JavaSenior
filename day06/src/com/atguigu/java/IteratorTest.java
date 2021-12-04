package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历 ,使用迭代器Iterator接口
 * 方法 hasNext next
 * @author xsj
 * @create 2020-09-20 19:11
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //NoSuchElementException
//        System.out.println(iterator.next());
        ////hasNext():判断是否还有下一个元素
        while (iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }
    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用 next 方法之后已经调用了 remove 方法，
    // 再调用remove都会报IllegalStateException。
    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("Tom".equals(next)){
                iterator.remove();
            }
        }
        iterator=coll.iterator();
        while (iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }

    }
}
