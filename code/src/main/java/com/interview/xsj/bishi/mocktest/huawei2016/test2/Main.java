package com.interview.xsj.bishi.mocktest.huawei2016.test2;

/**
 * @author xsj
 * @create 2021-07-19 17:10
 */
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.next();
            Set<Character> vis=new HashSet<>();
            StringBuilder sb=new StringBuilder();

            for(char c:str.toCharArray()){
                if(!vis.contains(c)){
                    sb.append(c);
                    vis.add(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
