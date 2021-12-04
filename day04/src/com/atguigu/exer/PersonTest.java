package com.atguigu.exer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xsj
 * @create 2020-09-19 20:50
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1=new Person("小明",23);
        Person p2=new Person("小红",25);
        Person p3=new Person("老板",33);
        Person[] company=new Person[3];
        company[0]=p1;
        company[1]=p2;
        company[2]=p3;
        //提供定制排序涉及到的接口的实现类对象，并按Person类的年龄从大到小排序
        Arrays.sort(company, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        System.out.println(Arrays.toString(company));
    }
}
