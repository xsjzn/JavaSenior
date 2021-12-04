package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author xsj
 * @create 2020-09-21 15:22
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象。
    2.两种排序方式：自然排序（实现Comparable接口） 和 定制排序（Comparator）


    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0.不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0.不再是equals().
    因为treeset和treemap底层是用红黑树(是一个排序二叉树，小的往左子树放，大的往右子树放)
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //失败不能添加不同类型的数据
//        set.add(456);
//        set.add(123);
//        set.add(123);
//        set.add("AA");
//        set.add("CC");
//        set.add(new User("Tom",12));
        //举例二：
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        TreeSet set=new TreeSet(new Comparator() {
            //按照年龄从小到大排
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User&&o2 instanceof  User){
                    User user1=(User)o1;
                    User user2=(User)o2;
                    return Integer.compare(user1.getAge(),user2.getAge());
                }
                throw new RuntimeException("传入类型不一致");
            }
        });
        set.add(new User("Tom",12));
        set.add(new User("Jerry",32));
        set.add(new User("Jim",2));
        set.add(new User("Mike",65));
        set.add(new User("Mary",33));
        set.add(new User("Jack",33));
        set.add(new User("Jack",56));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


}
