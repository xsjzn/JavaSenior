package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * /*
 *  * 一、说明：Java中的对象，正常情况下，只能进行比较：==  或  != 。不能使用 > 或 < 的
 *          但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *          如何实现？使用两个接口中的任何一个：Comparable 或 Comparator
 *
 * 二、Comparable接口与Comparator的使用的对比：
 *    Comparable接口的方式一旦一定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 *    Comparator接口属于临时性的比较

 * @author xsj
 * @create 2020-09-19 19:49
 */
public class CompareTest {
    @Test
    public void test1(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        //
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }
/*    Comparable接口的使用举例：  自然排序
 1.像String、包装类等实现了Comparable接口，重写了compareTo(obj)方法，给出了比较两个对象大小的方式。
            2.像String、包装类重写compareTo()方法以后，进行了从小到大的排列
 3. 重写compareTo(obj)的规则：
    如果当前对象this大于形参对象obj，则返回正整数，正数就认为当前的大，就把当前的往后放，因此默认是从小到大
    如果当前对象this小于形参对象obj，则返回负整数，
    如果当前对象this等于形参对象obj，则返回零。
            4. 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo(obj)方法。
    在compareTo(obj)方法中指明如何排序*/
    @Test
    public void test2(){
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("microsoftMouse",43);
        Arrays.sort(arr);

    }
    //
    @Test
    public void test3(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator<String>() {
            //按字符串从大到小排序
            @Override
            public int compare(String o1, String o2) {
                if(o1 instanceof String&& o2 instanceof String){
                    String str1=(String)o1;
                    String str2=(String)o2;
                    return -o1.compareTo(o2);
                }
                throw new RuntimeException("传入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test4(){
        Goods[] arr = new Goods[6];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",43);
        arr[2] = new Goods("xiaomiMouse",12);
        arr[3] = new Goods("huaweiMouse",65);
        arr[4] = new Goods("huaweiMouse",224);
        arr[5] = new Goods("microsoftMouse",43);
        //指明商品比较大小的方式:按照产品名称从低到高排序,再按照价格从高到低排序
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods&&o2 instanceof Goods ){
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                        return g1.getName().compareTo(g2.getName());
                    }

                }
                throw new RuntimeException("传入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
