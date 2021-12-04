package com.interview.xsj.bishi.mocktest.huswei2016_2.test1;

/**
 * @author xsj
 * @create 2021-07-23 14:58
 */
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] score=new int[n+1];
            for(int i=1;i<=n;i++){
                score[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                char c=sc.next().charAt(0);
                int left=sc.nextInt();
                int right=sc.nextInt();

                if(c=='Q'){
                    if(left>right){
                        int tmp=left;
                        left=right;
                        right=tmp;
                    }
                    int max=score[left];
                    for(int j=left+1;j<=right;j++){
                        max=Math.max(max,score[j]);
                    }
                    System.out.println(+max);
                }
                if(c=='U'){
                    score[left]=right;
                }
            }
        }
        sc.close();
    }

}