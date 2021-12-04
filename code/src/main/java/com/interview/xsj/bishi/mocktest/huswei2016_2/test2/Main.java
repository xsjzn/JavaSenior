package com.interview.xsj.bishi.mocktest.huswei2016_2.test2;

import java.util.*;

/**
 * @author xsj
 * @create 2021-07-23 16:48
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();//使用LinkedHashMap而非hashmap
        String key;
        String filename;
        String path;
        while(in.hasNext()){
            path = in.next();//E:\zxc\zxc\zxcvbnmzxc.c
            //将路径转换为文件名
            int id = path.lastIndexOf('\\');//zxcvbnmzxc.c
            //lastIndexOf(int ch) 返回指定字符在此字符串中最后一次出现处的索引。
            //如果找不到说明只有文件名没有路径
            filename = id<0 ? path : path.substring(id+1);//zxcvbnmzxc.c
            int linenum = in.nextInt();//23
            //统计频率
            key = filename+" "+linenum;//zxcvbnmzxc.c 23
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }
        in.close();
        List<Map.Entry<String,Integer>> list=new LinkedList<>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue()-o2.getValue()==0?o1.getValue()-o2.getValue():o2.getValue()-o1.getValue();
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String,Integer> mapping:list){
            m++;
            if(m<=8){
                String[] str=mapping.getKey().split(" ");//str[0]:zxcvbnmzxc.c  str[1]:23
                String k=str[0].length()>16?str[0].substring(str[0].length()-16):str[0];
                String n=str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());

            }else{
                break;
            }
        }

    }
}
