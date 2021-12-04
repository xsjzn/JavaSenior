package com.atguigu.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xsj
 * @create 2020-09-20 20:18
 */
public class ListExer {
    @Test
    public void testListRemove() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);//
    }
    private static void updateList(List list) {
//        list.remove(2);//这样是删除索引为2的元素
        list.remove(new Integer(2));//这样是删除元素2
    }


}
