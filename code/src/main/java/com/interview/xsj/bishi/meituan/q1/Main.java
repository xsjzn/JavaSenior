package com.interview.xsj.bishi.meituan.q1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xsj
 * @create 2021-04-04 10:04
 */
public class Main {
    private static int cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len=str.length();
        boolean[] vis=new boolean[len+1];
        Set<Character> set=new HashSet<>();
        //求组合数
        for(int i=0;i<=len;i++){
            backtracking(i,0,vis,new StringBuilder(),str,set);
        }
        System.out.println(cnt%20210101);
    }

    private static void backtracking(int len, int st, boolean[] vis, StringBuilder sb,String str,Set<Character> set) {
        if(sb.length()==len){
            System.out.println(sb.toString());
            cnt=(cnt+1)%20210101;
            return;
        }
        for(int i=st;i<str.length();i++){
            if(vis[i]||set.contains(str.charAt(i))){
                continue;
            }
            set.add(str.charAt(i));
            sb.append(str.charAt(i));
            vis[i]=true;
            backtracking(len,i+1,vis,sb,str,set);
            vis[i]=false;
            sb.deleteCharAt(sb.length()-1);
            set.remove(str.charAt(i));
        }
    }
}
