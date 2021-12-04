package chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 用代码来模拟多用户同时进入直播间时map信息的维护\
 * key为topic value为设备的list
 * @author xsj
 * @create 2020-10-24 17:53
 */
public class TestMap {
    static ConcurrentHashMap<String, List<String>> map= new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Thread threadOne =new Thread(()->{
            List<String> list1=new ArrayList<>();
            list1.add("device1");
            list1.add("device2");
            List<String> oldList=map.putIfAbsent("topic1",list1);
            if(null!=oldList){
                oldList.addAll(list1);
            }
            System.out.println(map);
        });
        Thread threadTwo =new Thread(()->{
            List<String> list1=new ArrayList<>();
            list1.add("device11");
            list1.add("device22");
            List<String> oldList=map.putIfAbsent("topic1",list1);
            if(null!=oldList){
                oldList.addAll(list1);
            }
            System.out.println(map);
        });
        Thread threadThree =new Thread(()->{
            List<String> list1=new ArrayList<>();
            list1.add("device111");
            list1.add("device222");
            List<String> oldList=map.putIfAbsent("topic2",list1);
            if(null!=oldList){
                oldList.addAll(list1);
            }
            System.out.println(map);
        });
        threadOne.start();
        threadTwo.start();
        threadThree.start();

    }
}
