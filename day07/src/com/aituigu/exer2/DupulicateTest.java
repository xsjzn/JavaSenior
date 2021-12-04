package com.aituigu.exer2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author xsj
 * @create 2020-09-21 16:52
 */
public class DupulicateTest {
    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }
}
