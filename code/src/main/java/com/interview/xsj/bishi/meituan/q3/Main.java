package com.interview.xsj.bishi.meituan.q3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author xsj
 * @create 2021-04-04 11:27
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        String[] strs=new String[n];
        int cnt=0;
        String hate=Integer.toString(k);
        for(int i=0;i<n;i++){
           nums[i]=sc.nextInt();
           strs[i]=generate(nums[i]);
//            System.out.print(strs[i]+" ");
            if(isSubStr(strs[i],hate)){
                cnt++;
            }
        }
        System.out.println(cnt);



    }

    private static boolean isSubStr(String str, String hate) {
        int i=0,j=0;
        while(i<str.length()&&j<hate.length()){
            if(str.charAt(i)==hate.charAt(j)){
                j++;
            }
            i++;
        }

        return j==hate.length();
    }

    private static String generate(int num) {
        List<Integer> nums=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i*i<=num;i++){
            if(num%i==0){
                nums.add(i);
                if(num/i!=i){
                    nums.add(num/i);
                }

            }
        }
        Collections.sort(nums);

        for(int n:nums){
            sb.append(n);
        }
//        for(int i=1;i<=num;i++){
//            if(num%i==0){
//                sb.append(i);
//            }
//        }
        return sb.toString();
    }
}
