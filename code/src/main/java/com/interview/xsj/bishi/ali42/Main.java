package com.interview.xsj.bishi.ali42;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author xsj
 * @create 2021-04-02 19:06
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){

            //输入
            int n=sc.nextInt();
            int[] nums=new int[n];
            for(int i=0;i<n;i++){
                nums[i]=sc.nextInt();
            }
            nums[n-1]++;
            for(int i=n-2;i>=0;i--){
                if(nums[i]+1!=nums[i+1]&&nums[i]!=nums[i+1]){
                    nums[i]++;
                }
            }
            Set<Integer> cnt=new HashSet<>();
            for(int num:nums){
                cnt.add(num);
            }
            System.out.println(cnt.size());
        }
    }
}
